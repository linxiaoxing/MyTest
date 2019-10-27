package com.example.aidlsam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.TextView;

import com.example.aidlsam.bean.Person;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity{

    TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        mTvResult = findViewById( R.id.tv_result );
        bindAIDLService();
    }

    private com.example.aidlsam.IMyAidl mAidl;

    private ServiceConnection mAIDLConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //连接后拿到 Binder，转换成 AIDL，在不同进程会返回个代理
            mAidl = com.example.aidlsam.IMyAidl.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mAidl = null;
        }
    };

    private void bindAIDLService() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("top.shixinzhang.myapplication", "top.shixinzhang.myapplication.service.MyAidlService"));
        bindService(intent, mAIDLConnection, BIND_AUTO_CREATE);

        Intent intent1 = new Intent(getApplicationContext(), MyAidlService.class);
        bindService(intent1, mAIDLConnection, BIND_AUTO_CREATE);
    }

    public void addPerson(View view) {
        Random random = new Random();
        Person person = new Person("shixin" + random.nextInt(10));

        try {
            mAidl.addPerson(person);
            List<Person> personList = mAidl.getPersonList();
            mTvResult.setText(personList.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
