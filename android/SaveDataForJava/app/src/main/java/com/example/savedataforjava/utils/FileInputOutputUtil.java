package com.example.savedataforjava.utils;

import android.content.Context;
import android.util.Log;

import com.example.savedataforjava.app.MyApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class FileInputOutputUtil{

    private static final String LOCAL_FILE = "/students.txt";

    public static String sampleFileInput(Context context){

        InputStream in;
        String lineBuffer;
        String str = "";
        try {
            File yourFile = new File(context.getFilesDir().getPath() + LOCAL_FILE);
            if(!yourFile.exists()) {
                return "file is not Found";
            }
            //in = context.openFileInput(context.getFilesDir().getPath() + LOCAL_FILE); //LOCAL_FILE = "log.txt";
            in = new FileInputStream(context.getFilesDir().getPath() + LOCAL_FILE);
            BufferedReader reader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
            while( (lineBuffer = reader.readLine()) != null ){
                Log.d("FileAccess",lineBuffer);
                str = str + lineBuffer;
            }
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        return str;
    }

    public static void sampleFileOutput(Context context, String writeContext){

        OutputStream out;
        try {
            File yourFile = new File(context.getFilesDir().getPath() + LOCAL_FILE);
            if(!yourFile.exists()) {
                yourFile.createNewFile();
            }
            // out = context.openFileOutput(context.getFilesDir().getPath() + LOCAL_FILE, Context.MODE_PRIVATE);
            out = new FileOutputStream(new File(context.getFilesDir().getPath() + LOCAL_FILE));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(out,"UTF-8"));

            //追記する
            writer.append(writeContext);
            writer.close();
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
    }

}
