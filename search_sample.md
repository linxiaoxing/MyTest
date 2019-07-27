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
| city | array[string] | × | 市区町村コード |
| line | array[integer] | × | 路線ID |
| station | array[integer] | × | 駅グループコード |
| salary_type | integer | × | 給与タイプID |
| salary_min | integer | × | 給与下限のValue |
| salary_max | integer | × | 給与上限のValue |
| employment | array[integer] | × |  特徴ID（雇用形態） |
| feature | array[integer] | × | 特徴ID（特徴） |
| welfare | array[integer] | × | 特徴ID（待遇・福利厚生） |
| workstyle | array[integer] | × | 特徴ID（勤務時間） |
| working_day | array[integer] | × | 特徴ID（勤務日数） |
| experience | array[integer] | × | 特徴ID（必要経験） |
| facility_type | array[integer] | × | 特徴ID（施設形態） |
| occupation | array[integer] | × | 特徴ID（役職） |
| work_description | array[integer] | × | 特徴ID（仕事内容） |
| holiday | array[integer] | × | 特徴ID（休日） |
| customer_type | array[integer] | × | 特徴ID（客層） |
| user_credential | array[integer] | × | 特徴ID（資格） |
| keywords | string | × | キーワード |
| sort | string | × | 並び替え |
| page | integer | × | ページング |

#### sortで指定するパラメータ
| パラメータ名 | 説明 |
| ---------- | --- |
| grouping | 標準 |
| new | 新着 |
| popular | 人気 |
| salary | 月給 |

### レスポンス

| パラメータ名 | 型 | 説明 |
| ---------- | :---: | --- |
| work_id | integer | 求人ID |
| work_code | string | 求人コード |
| work_title | string | 求人タイトル |
| client_name | string | 企業名もしくはブランド名 <br>※ブランド名がある場合はブランド名を優先 |
| client_url | string | ブランドURL |
| client_shop_map_latitude | float | map表示用緯度 |
| client_shop_map_longitude | float | map表示用経度|
| client_shops | array[client_shops] | 店舗 |
| workhour | string | 勤務時間|
| salaries | array[salary] | 給与形態のリスト |
| thumbnail_path | string | 求人イメージのPATH |
| enterable | boolean | 応募できるか否か|
| is_entered | boolean | 応募済みか否か|
| is_keeping | boolean | キープ済みか否か|
| is_scouted | boolean | スカウトか否か|
| post_date | date | 掲載開始日|

#### 店舗 (client_shops)

| パラメータ名 | 型 | 説明 |
| ---------- | :---: | --- |
| client_shop_id | integer | 店舗ID |
| client_shop_name | string | 店舗名 |
| client_shop_place | string | 勤務地 |
| client_shop_latitude | float | 緯度 |
| client_shop_longitude | float | 経度|

#### 給与形態（salary）

| パラメータ名 | 型 | 説明 |
| ---------- | :---: | --- |
| salary_min | integer | 給与の下限 |
| salary_max | integer | 給与の上限 |
| employment_type | dictionary | 雇用形態 |
| employment_type.id | integer | 雇用形態ID |
| employment_type.name | string | 雇用形態の名称 |
| salary_type | dictionary | 給与形態 |
| salary_type.id | integer | 給与形態ID |
| salary_type.name | string | 給与形態の名称 |

#### リクエスト例

```json
{
  "prefecture":[13],
  "business_type":[1,2,3],
  "popular_area":[1],
  "city":["13101"],
  "line":[11302],
  "station":[1130208],
  "salary_type":1,
  "salary_min":800,
  "salary_max":1000,
  "employment":[1],
  "feature":[10,7],
  "welfare":[24,25],
  "workstyle":[43],
  "working_day":[1],
  "experience":[47],
  "facility_type":[57],
  "occupation":[76],
  "work_description":[102],
  "holiday":[1],
  "customer_type":[162],
  "user_credential":[119],
  "keywords": "リジョブ",
  "sort":"grouping",
  "page":1
}
```

#### レスポンス例

```json
{
  "search_result_works": [
    {
      "work_id": 1,
      "work_code": "1",
      "work_title": "求人タイトル",
      "client_name": "会社名",
      "client_url": "ブランドURL",
      "client_shop_map_latitude": 35.6684499,
      "client_shop_map_longitude": 139.7060758,
      "client_shops": [
        {
          "client_shop_id": 1,
          "client_shop_name": "店舗名",
          "client_shop_place": "勤務地",
          "client_shop_latitude": 35.6684499,
          "client_shop_longitude": 139.7060758,
        }
      ],
      "workhour": "勤務時間",
      "salaries": [
        {
          "salary_min": 200000,
          "salary_max": 500000,
          "employment_type": {
            "id": 2,
            "name": "正社員"
          },
          "salary_type": {
            "id": 3,
            "name": "月給"
          }
        }
      ],
      "thumbnail_path": "imageのパス",
      "enterable": true,
      "is_entered": true,
      "is_keeping": false,
      "is_scouted": true,
      "post_date": "2018/07/19 11:00",
    }
  ]
}
```
