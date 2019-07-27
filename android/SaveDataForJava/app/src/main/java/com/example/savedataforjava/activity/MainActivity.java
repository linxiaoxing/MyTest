package com.example.savedataforjava.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.savedataforjava.R;
import com.example.savedataforjava.data.SerializableData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button file;
    Button preference;
    Button sqlite;
    Button serializable;
    Button sdCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        file = (Button)findViewById( R.id.file );
        preference = (Button)findViewById( R.id.preference );
        sqlite = (Button)findViewById( R.id.sqlite );
        serializable = (Button)findViewById( R.id.serializable );
        sdCard = (Button)findViewById( R.id.sdcard );

        file.setOnClickListener( this );
        preference.setOnClickListener( this );
        sqlite.setOnClickListener( this );
        serializable.setOnClickListener( this );
        sdCard.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.file:
                intent = new Intent( this, FileInputOutputActivity.class );
                startActivity( intent );
                break;
            case R.id.preference:
                intent = new Intent( this, PreferenceActivity.class );
                startActivity( intent );
                break;
            case R.id.sqlite:
                intent = new Intent( this, SQLiteActivity.class );
                startActivity( intent );
                break;
            case R.id.serializable:
                intent = new Intent( this, SerializableActivity.class );
                startActivity( intent );
                break;
            case R.id.sdcard:
                intent = new Intent( this, SdcardActivity.class );
                startActivity( intent );
                break;

        }
    }
}
