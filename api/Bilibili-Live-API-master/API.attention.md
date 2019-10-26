## 批量关注主播

#### 调用地址

https://api.live.bilibili.com/liveact/attention

需要 Cookies，并验证登录状态(Cookies)

#### 参数

|字段|必选|传递方式|类型|说明|
|----|----|--------|----|----|
|cookie|true|POST|string|发布帐号(必须和 Cookies 帐号一致)|
|type|true|POST|string|1为关注，0为取消|
|uid|true|POST|string|直播房间号|
|csrf_token|true|POST|string|与 cookie 中 bili_jct 值一致（fce9ff23db2a8da348172da7e8972020）|
