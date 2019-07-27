package com.example.savedataforjava.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.savedataforjava.R;
import com.example.savedataforjava.utils.FileInputOutputUtil;

public class FileInputOutputActivity extends Activity implements View.OnClickListener{

    EditText editText;
    Button writeBtn;
    Button readBtn;
    TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_file );
        editText = (EditText)findViewById( R.id.editTextFile );
        writeBtn = (Button)findViewById( R.id.write );
        readBtn = (Button)findViewById( R.id.read );
        showText = (TextView)findViewById( R.id.showtext );

        writeBtn.setOnClickListener( this );
        readBtn.setOnClickListener( this );

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.write:
                FileInputOutputUtil.sampleFileOutput(this, editText.getText().toString());
                break;

            case R.id.read:
                String text = FileInputOutputUtil.sampleFileInput(this);
                showText.setText( text );
                break;
        }
    }
}
