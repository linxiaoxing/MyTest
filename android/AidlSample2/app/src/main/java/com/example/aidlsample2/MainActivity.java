package com.example.aidlsample2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "DEBUG-WCL: " + MainActivity.class.getSimpleName();

    private static final int MESSAGE_NEW_BOOK_ARRIVED = 1;

    private TextView mTvBookList;

    private com.example.aidlsample2.IBookManager mRemoteBookManager;

    private com.example.aidlsample2.IOnNewBookArrivedListener mOnNewBookArrivedListener = new com.example.aidlsample2.IOnNewBookArrivedListener.Stub() {
        @Override public void onNewBookArrived(Book newBook) throws RemoteException {
            mHandler.obtainMessage(MESSAGE_NEW_BOOK_ARRIVED, newBook).sendToTarget();
        }
    };

    private Handler mHandler = new Handler() {
        @Override public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_NEW_BOOK_ARRIVED:
                    Log.e(TAG, "收到的新书: " + msg.obj);
                    new BookListAsyncTask().execute();
                    break;
                default:
                    super.handleMessage(msg);
                    break;
            }
        }
    };

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override public void onServiceConnected(ComponentName name, IBinder service) {
            com.example.aidlsample2.IBookManager bookManager = com.example.aidlsample2.IBookManager.Stub.asInterface(service);
            try {
                mRemoteBookManager = bookManager;
                Book newBook = new Book(3, "学姐的故事");
                bookManager.addBook(newBook);
                new BookListAsyncTask().execute();
                bookManager.registerListener(mOnNewBookArrivedListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override public void onServiceDisconnected(ComponentName name) {
            mRemoteBookManager = null;
            Log.e(TAG, "绑定结束");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvBookList = (TextView) findViewById(R.id.main_tv_book_list);

    }

    @Override protected void onDestroy() {
        if (mRemoteBookManager != null && mRemoteBookManager.asBinder().isBinderAlive()) {
            try {
                Log.e(TAG, "解除注册");
                mRemoteBookManager.unregisterListener(mOnNewBookArrivedListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        try {
            unbindService(mConnection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    /**
     * 绑定服务按钮的点击事件
     *
     * @param view 视图
     */
    public void bindService(View view) {
        Intent intent = new Intent(this, BookManagerService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    /**
     * 获取图书数量的异步线程, 直接绑定点击事件
     *
     * @param view 视图
     */
    public void getBookList(View view) {
        new BookNumAsyncTask().execute();
        Toast.makeText(getApplicationContext(), "正在获取中...", Toast.LENGTH_SHORT).show();
    }

    private class BookNumAsyncTask extends AsyncTask<Void, Void, Integer>{
        @Override protected Integer doInBackground(Void... params) {
            return getListNum();
        }

        @Override protected void onPostExecute(Integer integer) {
            Toast.makeText(getApplicationContext(), "图书数量: " + integer, Toast.LENGTH_SHORT).show();
        }
    }

    private class BookListAsyncTask extends AsyncTask<Void, Void, List<Book>> {
        @Override protected List<Book> doInBackground(Void... params) {
            List<Book> list = null;
            try {
                list = mRemoteBookManager.getBookList();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            return list;
        }

        @Override protected void onPostExecute(List<Book> books) {
            String content = "";
            for (int i = 0; i < books.size(); ++i) {
                content += books.get(i).toString() + "\n";
            }
            mTvBookList.setText(content);
        }
    }

    /**
     * 获取列表的图书数量
     *
     * @return 数量
     */
    private int getListNum() {
        int num = 0;
        if (mRemoteBookManager != null) {
            try {
                List<Book> list = mRemoteBookManager.getBookList();
                num = list.size();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return num;
    }
}
