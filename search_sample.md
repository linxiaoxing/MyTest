## 求人検索API
検索条件を指定し、求人一覧の情報を取得するAPIです。
ページごとに最大10件ずつ返します。

### エンドポイント
```
URL: v3/works/work_search
method: POST
```

### リクエスト

| パラメータ名 | 型 | 必須 | 説明 |
| ---------- | ---- | :---: | --- |
| access_token | string |  | アクセストークン（※ログイン時必須） |
| prefecture | array[integer] | × | 都道府県ID |
| business_type | array[integer] | × | 業種ID |
| popular_area | array[integer] | × | エリアID |
