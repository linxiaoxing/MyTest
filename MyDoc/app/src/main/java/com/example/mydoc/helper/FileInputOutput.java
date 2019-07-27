package com.example.mydoc.helper;

import android.content.Context;
import android.util.Log;
import com.example.mydoc.MyDocApplication;

import java.io.*;

//ローカルファイルへデータ保存する方法について、
//        今回はandroid.content.Contextに用意されているファイル入出力(ファイルI/O)に便利なメソッド、
//        ファイルを読み込むopenFileInput()、書き込みのopenFileOutput()について紹介します
//ローカルファイルへデータ保存する: https://techbooster.org/android/application/1629/

public class FileInputOutput {

    private MyDocApplication app;
    private static final String LOCAL_FILE = "index";

    private void sampleFileInput() {

        InputStream in;
        String lineBuffer;

        try {
            in = app.openFileInput(LOCAL_FILE); //LOCAL_FILE = "log.txt";

            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            while ((lineBuffer = reader.readLine()) != null) {
                Log.d("FileAccess", lineBuffer);
            }
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

    }

    private void sampleFileOutput(){

        OutputStream out;
        try {
            out = app.openFileOutput(LOCAL_FILE,Context.MODE_PRIVATE| Context.MODE_APPEND);
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(out,"UTF-8"));

            //追記する
            writer.append("write test");
            writer.close();
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
    }
}
