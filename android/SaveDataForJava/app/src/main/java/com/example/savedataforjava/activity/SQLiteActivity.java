package com.example.savedataforjava.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.savedataforjava.R;

//        static SQLiteDatabase mydb;
//
//        MySQLiteOpenHelper hlpr = new MySQLiteOpenHelper(getApplicationContext());
//        mydb = hlpr.getWritableDatabase();
//        データベースを読み書きするときにはgetWritableDatabase()を呼び出し、
//        読み取り専用で良い場合はgetReadableDatabase()を呼び出します。

//行の挿入
//        行の挿入はinsertメソッドで行います。 引数と戻り値は以下のようになっています。
//
//        long insert(String  table, String  nullColumnHack, ContentValues  values)
//        各フィールドのデータはContentValuesクラスを使って設定します。 使い方としては以下のようになります。
//
//        ContentValues values = new ContentValues();
//        values.put("data", "data1");
//        mydb.insert("mytable", null, values);
//        この例ではdataというフィールドがdata1の行を挿入しています。
//
//行の検索
//        行の検索にはqueryメソッドを使います。 引数と戻り値は以下のようになっています。
//
//        Cursor query(boolean distinct, String  table, String[]  columns, String  selection, String[]  selectionArgs, String  groupBy, String  having, String  orderBy, String  limit)
//        たとえば、上で定義したmytableテーブルから全データを検索したい場合は以下のようにします。
//
//        1
//        Cursor cursor = mydb.query("mytable", new String[] {"_id", "data"}, null, null, null, null, "_id DESC");
// 行の削除
//        行の検索にはdeleteメソッドを使います。 引数と戻り値は以下のようになっています。
//
//        int delete(String  table, String  whereClause, String[]  whereArgs)
//        mytableテーブルのデータを全削除するには以下のようにします。
//
//        1
//        mydb.delete("mytable", "_id like '%'", null);

public class SQLiteActivity extends Activity implements View.OnClickListener{
    static final String DB = "sqlite_sample.db";
    static final int DB_VERSION = 1;
    static final String CREATE_TABLE = "create table mytable ( _id integer primary key autoincrement, data integer not null );";
    static final String DROP_TABLE = "drop table mytable;";

    static SQLiteDatabase mydb;

    private SimpleCursorAdapter myadapter;

    private ListView listview;
    private Button addbtn, delbtn;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_sqlite);

        MySQLiteOpenHelper hlpr = new MySQLiteOpenHelper(getApplicationContext());
        mydb = hlpr.getWritableDatabase();

        Cursor cursor = mydb.query("mytable", new String[] {"_id", "data"}, null, null, null, null, "_id DESC");
        String[] from = new String[] {"_id", "data"};
        int[] to = new int[] {R.id._id, R.id.data};
        myadapter = new SimpleCursorAdapter(this, R.layout.db_data, cursor, from, to);

        listview = (ListView)findViewById(R.id.ListView);
        listview.setAdapter(myadapter);

        addbtn = (Button)findViewById(R.id.Add);
        addbtn.setOnClickListener(this);
        delbtn = (Button)findViewById(R.id.Delete);
        delbtn.setOnClickListener(this);

    }

    private static class MySQLiteOpenHelper extends SQLiteOpenHelper{
        public MySQLiteOpenHelper(Context c) {
            super(c, DB, null, DB_VERSION);
        }
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.Add) {
            ContentValues values = new ContentValues();
            values.put("data", "data");
            mydb.insert("mytable", null, values);

            Cursor cursor = mydb.query("mytable", new String[] {"_id", "data"}, null, null, null, null, "_id DESC");
            startManagingCursor(cursor);
            myadapter.changeCursor(cursor);
        } else if (view.getId() == R.id.Delete) {
            mydb.delete("mytable", "_id like '%'", null);

            Cursor cursor = mydb.query("mytable", new String[] {"_id", "data"}, null, null, null, null, "_id DESC");
            startManagingCursor(cursor);
            myadapter.changeCursor(cursor);
        }
    }
}