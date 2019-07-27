package com.example.savedataforjava.activity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.savedataforjava.R;

//データを簡単に保存する方法(PREFERENCE編)
//
//        保存する方法としては以下のものがあります。
//
//        ファイルとして保存
//        Preference
//        データベース（SQLite）
//        今回はPreferenceを取り上げてみようと思います。
//
//        SHAREDPREFERENCES
//        SharedPreferencesとは、Androidで簡単にデータを保存/読込を行う仕組みです。
//        具体的にはキーと値をセットで保持し、XML形式としてshared_prefフォルダに保存されます。
//
//        保存できる値
//        int
//        float
//        long
//        boolean
//        String
//        保存、読み込みのためのメソッド
//
//
//        putInt(String key, int value)
//        putFloat(String key, float value)
//        putLong(String key, long value)
//        putBoolean(String key, boolean value)
//        putString(String key, String value)
//        getInt(String key, int defValue)
//        getFloat(String key, float defValue)
//        getLong(String key, long defValue)
//        getBoolean(String key, boolean defValue)
//        getString(String key, String defValue)
//        読み込みはSHAREDPREFERENCESのEDITメソッドを使って、SHAREDPREFERENCES.EDITORクラスを取得してから行います。
//        保存はput〜〜メソッドを呼び出した後にcommitメソッドを呼び出す必要があります。

public class PreferenceActivity extends AppCompatActivity{

    TextView showText;
    EditText editText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_preference);

        Button saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                saveButtonClick();
            }
        });

        Button loadButton = (Button)findViewById(R.id.loadButton);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                loadButtonClick();
            }
        });

        showText = (TextView)findViewById( R.id.showtextP );
        editText = (EditText)findViewById(R.id.editText01);
    }

    private void saveButtonClick() {
        // 保存
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        sp.edit().putString("SaveString", editText.getText().toString()).commit();
    }

    private void loadButtonClick() {
        // 読み込み
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        showText.setText(sp.getString("SaveString", null), TextView.BufferType.NORMAL);
    }
}
