package com.example.savedataforjava.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//データベースが存在しない状態でデータベースをオープンしようとするとonCreateメソッドが呼ばれます。
//        この際、onCreateメソッドの引数には新規作成されたデータベースのインスタンスが渡されますので、
//        このインスタンスのexecSQLを使ってテーブルの作成を行います。
//        この例では_idという名前の自動連番にdataという名前の数値データを格納するテーブル(mytableという名前)
//        を作成しています。 また、SQLiteOpenHelperはデータベースのバージョン情報を保持しています。
//        テーブルのバージョンが更新された場合はこのバージョンも更新されます。
//        このバージョンはSQLiteOpenHelperのコンストラクタで引数として与えるようになっており、
//        もし与えられたバージョン情報と実際に存在するデータベースのバージョンが異なる場合は
//        onUpgradeメソッドが呼び出されます。 onUpgradeメソッドではテーブル構造の再構成などの処理を行います。

public class MySQLiteOpenHelper extends SQLiteOpenHelper{

    static final String DB = "sqlite_sample.db";
    static final int DB_VERSION = 1;
    static final String CREATE_TABLE = "create table mytable ( _id integer primary key autoincrement, data integer not null );";
    static final String DROP_TABLE = "drop table mytable;";

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