package com.example.savedataforjava.activity;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.savedataforjava.R;
import com.example.savedataforjava.data.SerializableData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;

// 内蔵ストレージが少ない端末もあるため、大きいファイルはSDカードに保存したいものです

// また、SDカードに保存することで、ユーザーがパソコンを繋いでデータをコピーすることも可能になります

// 注意する点が二つ
//SD カードのパスは端末によってことなる場合があります。私の手元の端末では
//
//        /sdcard
//
//        /mnt/sdcard/
//
//        の2つのパターンがありました。
//
//        もしかすると端末によってはこれ以外のパスがSDカードに割り当てられているかもしれません。また、同じ端末でもOSのアップデートによってパスが変わらないとも限りません。
//
//        そこでAndroidではSDカード、正確には外部ストレージのパスを知ることができるメソッドが用意されています。直接/sdcardのように指定するのではなく、用意されているメソッドを利用しましょう。
//        Environment.getExternalStorageDirectory()でFileインスタンスを取得でき、getPathメソッドでパスを取得します。
//
//
//        import android.os.Environment;
//
//        Environment.getExternalStorageDirectory().getPath();
//        アプリケーションはできるかぎり特定の端末に依存せず、様々な端末で問題なく動作するようにしておいた方が多くの方に利用して頂けます。
//        他に端末に依存せずパスを取得するメソッドとして以下に例をあげておきます。
//
//        Environment.getDataDirectory().getPath(); // /dataなど
//        Environment.getDownloadCacheDirectory().getPath(); // cacheなど

public class SdcardActivity extends Activity {

    TextView showText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sdcard );

        Button buttonSave = (Button)findViewById(R.id.ButtonSave);
        buttonSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                    return;
                }
                if (ContextCompat.checkSelfPermission(SdcardActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {

                    // Permission is not granted
                    // Should we show an explanation?
                    if (ActivityCompat.shouldShowRequestPermissionRationale(SdcardActivity.this,
                            Manifest.permission.READ_CONTACTS)) {
                        // Show an explanation to the user *asynchronously* -- don't block
                        // this thread waiting for the user's response! After the user
                        // sees the explanation, try again to request the permission.
                    } else {
//                        // No explanation needed; request the permission
//                        ActivityCompat.requestPermissions(SdcardActivity.this,
//                                new String[]{Manifest.permission.READ_CONTACTS},
//                                WRITE_EXTERNAL_STORAGE);

                        // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                        // app-defined int constant. The callback method gets the
                        // result of the request.
                    }
                } else {
                    // Permission has already been granted
                }
                String filePath = Environment.getExternalStorageDirectory() + "/memo.txt";
                File file = new File(filePath);
                file.getParentFile().mkdir();

                FileOutputStream fos;
                try {
                    fos = new FileOutputStream(file, true);
                    OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                    BufferedWriter bw = new BufferedWriter(osw);
                    String str = ((EditText) findViewById(R.id.EditTextInput)).getText().toString();
                    bw.write(str);
                    bw.flush();
                    bw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
        });

        showText = (TextView)findViewById( R.id.textView );
        Button buttonShow = (Button)findViewById(R.id.ButtonShow);
        buttonShow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                    return;
                }
                String filePath = Environment.getExternalStorageDirectory() + "/memo.txt";
                try {
                    FileInputStream fis = openFileInput(filePath);
                    byte[] bytes = new byte[1024];
                    fis.read(bytes);
                    fis.close();
                    showText.setText( bytes.toString() );
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
        });
    }


}
