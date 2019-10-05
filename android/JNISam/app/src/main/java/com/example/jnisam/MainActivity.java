package com.example.jnisam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        TextView textView = findViewById( R.id.text );
        String s = new JNI().sayHello();
        textView.setText( s );
    }
}
