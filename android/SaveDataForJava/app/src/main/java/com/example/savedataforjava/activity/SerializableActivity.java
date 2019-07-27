package com.example.savedataforjava.activity;

//データ用のクラスを用意し、複数のフィールドに値を入れて管理するという方法を取ることがあるかと思います

// Preferenceを使う方法でフィールドを１つずつ保存していくということも考えられますが、データのオブジェクトごと保存ができると復元の時も含めて手軽に行うことができますね。

//import java.io.Serializable;JAVA.IO.SERIALIZABLEインタフェース
//        オブジェクトをシリアライズ可能にするには、そのクラスがjava.io.Serializableインタフェース（以下、Serializableインタフェース）を実装する必要があります。
//
//        1
//        public class HogeClass implements Serializable
//        Serializableインタフェースはメソッド、フィールドがなく、シリアライズが可能であるという意味を識別する機能だけを備えています。
//        ですので、上記の例のように implements Serializable とだけ記述すれば、他にメソッドを実装するなどの手間は必要ありません。
//
//        ただし、注意事項があります。クラス内のフィールドはプリミティブ型（intやboolean）か、もしくはシリアライズ可能なクラスでなければなりません。
//
//        シリアルバージョンID
//        シリアライズ、デシリアライズの前後で、クラスのバージョンが異なっていないかを識別する為にserialVersionUIDを定義します。定義しなくても動作しますが、定義しておくと万が一シリアライズした時から、デシリアライズまでにクラスの中身が変更されていた場合に例外を発生させてくれます。
//
//        1
//        private static final long serialVersionUID = 6255752248513019027L;
//        serialVersionUIDが定義されていないと警告を出します。
//
//
//        Eclipseですと、この場合にシリアルバージョンIDを生成させることも可能です。
//        「生成シリアル・バージョンIDの追加」を選択すると自動で計算して定義を追加してくれます。

//OBJECTOUTPUTSTREAM、OBJECTINPUTSTREAM
//        シリアライズ可能なクラスを用意したところで、次は実際にどのようにファイルに保存するのかを説明します。
//
//        そこで登場するのがObjectOutputStreamクラスとObjectInputStreamクラスです。
//
//        ObjectOutputStreamのコンストラクタは ObjectOutputStream(OutputStream out) です。今回はファイルに書き込みたいのでFileOutputStreamを指定します。
//
//        そして、writeObjectメソッドの引数にシリアライズ可能なオブジェクトを与えることでObjectOutputStreamクラスは指定されたオブジェクトをシリアライズしてストリームにアウトプットします

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.savedataforjava.R;
import com.example.savedataforjava.data.SerializableData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableActivity extends Activity implements View.OnClickListener {

    EditText editText;
    Button saveBtn;
    Button showBtn;
    TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_serializable );
        editText = (EditText)findViewById( R.id.editText );
        saveBtn = (Button)findViewById( R.id.save );
        showBtn = (Button)findViewById( R.id.show );
        showText = (TextView)findViewById( R.id.textView );

        saveBtn.setOnClickListener( this );
        showBtn.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                SerializableData data = new SerializableData();
                data.setString(editText.getText().toString());
                //data.setNumber(Integer.parseInt(editText.getText().toString()));
                try {
                    FileOutputStream fos = openFileOutput("SaveData.dat", MODE_PRIVATE);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(data);
                    oos.close();
                } catch (Exception e) {
                    // Log.d(TAG, "Error");
                }
                break;

            case R.id.show:
                try {
                    FileInputStream fis = openFileInput("SaveData.dat");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    SerializableData showData = (SerializableData) ois.readObject();
                    showText.setText( showData.getString() );
                    ois.close();
                } catch (Exception e) {
                    //Log.d(TAG, "Error");
                }
                break;
        }
    }
}
