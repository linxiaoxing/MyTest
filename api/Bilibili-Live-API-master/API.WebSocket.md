## WebSocket

Bilibili 直播弹幕 WebSocket 协议

### 调用地址

* 普通未加密的 WebSocket 连接： `ws://broadcastlv.chat.bilibili.com:2244/sub`
* 使用 SSL 的 WebSocket 连接： `wss://broadcastlv.chat.bilibili.com/sub`

### 数据包格式

发送和接收的包都是这种格式。

| 偏移 | 长度 | 类型 | 字节序 | 名称 | 说明 |
| --- | --- | --- | --- | --- | --- |
| 0 | 4 | int | Big Endian | Packet Length | 数据包长度 |
| 4 | 2 | int | Big Endian | Header Length | 数据包头部长度（固定为 `16`） |
| 6 | 2 | int | Big Endian | Protocol Version | 协议版本（见下文） |
| 8 | 4 | int | Big Endian | Operation | 操作类型（见下文） |
| 12 | 4 | int | Big Endian | Sequence Id | 数据包头部长度（固定为 `1`） |
| 16 | - | byte[] | - | Body | 数据内容 |

同一个 `WebSocket Frame` 可能包含多个 `Bilibili 直播数据包`，每个 `Bilibili 直播数据包` 直接首尾相连，数据包长度只表示 `Bilibili 直播数据包` 的长度，并非 `WebSocket Frame` 的长度。

#### 协议版本

| 值 | Body 格式 | 说明 |
| --- | --- | --- |
| 0 | JSON | JSON纯文本，可以直接通过 `JSON.stringify` 解析 |
| 1 | Int 32 Big Endian | Body 内容为房间人气值 |
| 2 | Buffer | 压缩过的 Buffer，Body 内容需要用zlib.inflate解压出一个新的数据包，然后从数据包格式那一步重新操作一遍 |

#### 操作类型

| 值 | 发送者 | Body 格式 | 名称 | 说明 |
| --- | --- | --- | --- | --- |
| 2 | 客户端 | (空) | 心跳 | 不发送心跳包，70 秒之后会断开连接，通常每 30 秒发送 1 次 |
| 3 | 服务器 | Int 32 Big Endian | 心跳回应 | Body 内容为房间人气值 |
| 5 | 服务器 | JSON | 通知 | 弹幕、广播等全部信息 |
| 7 | 客户端 | JSON | 进房 | WebSocket 连接成功后的发送的第一个数据包，发送要进入房间 ID |
| 8 | 服务器 | (空) | 进房回应 | |

#### 进房 JSON 内容

```json
{
  "clientver": "1.6.3",
  "platform": "web",
  "protover": 2,
  "roomid": 23058,
  "uid": 0,
  "type": 2
}
```

| 字段 | 必选 | 类型 | 说明|
| --- | --- | --- | --- |
| clientver | false | string | 例如 `"1.5.10.1"` |
| platform | false | string | 例如 `"web"` |
| protover | false | number | `1` 或者 `2` |
| roomid | true | number | 房间长 ID，可以通过 `room_init` API 获取 |
| uid | false | number | uin，可以通过 `getUserInfo` API 获取 |
| type | false | number | 不知道啥，总之写 `2` |

* protover 为 `1` 时不会使用zlib压缩，为 `2` 时会发送带有zlib压缩的包，也就是数据包协议为 `2` 。

#### 心跳回应

内容是一个 4 字节的 Big Endian 的 整数，表示房间人气

### 连接过程

这里以浏览器 JavaScript 自带的 `WebSocket` 说明

1. 声明encode和decode方法
```javascript
const textEncoder = new TextEncoder('utf-8');
const textDecoder = new TextDecoder('utf-8');

const readInt = function(buffer,start,len){
  let result = 0
  for(let i=len - 1;i >= 0;i--){
    result += Math.pow(256,len - i - 1) * buffer[start + i]
  }
  return result
}

const writeInt = function(buffer,start,len,value){
  let i=0
  while(i<len){
    buffer[start + i] = value/Math.pow(256,len - i - 1)
    i++
  }
}

const encode = function(str,op){
  let data = textEncoder.encode(str);
  let packetLen = 16 + data.byteLength;
  let header = [0,0,0,0,0,16,0,1,0,0,0,op,0,0,0,1]
  writeInt(header,0,4,packetLen)
  return (new Uint8Array(header.concat(...data))).buffer
}
const decode = function(blob){
  return new Promise(function(resolve, reject) {
    let reader = new FileReader();
    reader.onload = function (e){
      let buffer = new Uint8Array(e.target.result)
      let result = {}
      result.packetLen = readInt(buffer,0,4)
      result.headerLen = readInt(buffer,4,2)
      result.ver = readInt(buffer,6,2)
      result.op = readInt(buffer,8,4)
      result.seq = readInt(buffer,12,4)
      if(result.op === 5){
        result.body = []
        let offset = 0;
        while(offset < buffer.length){
          let packetLen = readInt(buffer,offset + 0,4)
          let headerLen = 16// readInt(buffer,offset + 4,4)
          let data = buffer.slice(offset + headerLen, offset + packetLen);
          let body = textDecoder.decode(data);
          if(body){
            result.body.push(JSON.parse(body));
          }
          offset += packetLen;
        }
      }else if(result.op === 3){
        result.body = {
          count: readInt(buffer,16,4)
        };
      }
      resolve(result)
    }
    reader.readAsArrayBuffer(blob);
  });
}
```


2. 连接 WebSocket并发送进入房间请求

```javascript
const ws = new WebSocket('wss://broadcastlv.chat.bilibili.com:2245/sub');
ws.onopen = function () {
  ws.send(encode(JSON.stringify({
    roomid: 23058
  }), 7));
};
// 如果使用的是控制台，这两句一定要一起执行，否侧onopen不会被触发
```

这个数据包必须为连接以后的第一个数据包，5 秒内不发送进房数据包，服务器主动断开连接，任何数据格式错误将直接导致服务器主动断开连接。

3. 每隔 30 秒发送一次心跳

```javascript
setInterval(function () {
  ws.send(encode('', 2));
}, 30000);
```

4. 接收

```javascript
ws.onmessage = async function (msgEvent) {
  const packet = await decode(msgEvent.data);
  switch (packet.op) {
    case 8:
      console.log('加入房间');
      break;
    case 3:
      const count = packet.body.count
      console.log(`人气：${count}`);
      break;
    case 5:
      packet.body.forEach((body)=>{
        switch (body.cmd) {
          case 'DANMU_MSG':
            console.log(`${body.info[2][1]}: ${body.info[1]}`);
            break;
          case 'SEND_GIFT':
            console.log(`${body.data.uname} ${body.data.action} ${body.data.num} 个 ${body.data.giftName}`);
            break;
          case 'WELCOME':
            console.log(`欢迎 ${body.data.uname}`);
            break;
          // 此处省略很多其他通知类型
          default:
            console.log(body);
        }
      })
      break;
    default:
      console.log(packet);
  }
};
```
