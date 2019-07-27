package com.anjoyo.liuxiaowei;

import java.util.ArrayList;
import java.util.List;

import com.anjoyo.adapter.ShopAdapter;
import com.anjoyo.info.ShopInfo;
import com.anjoyo.model.Model;
import com.anjoyo.net.MyGet;
import com.anjoyo.net.ThreadPoolUtils;
import com.anjoyo.thread.HttpGetThread;
import com.anjoyo.utils.MyJson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 团购模块
 * */
public class TuanActivity extends Activity {

	// 导航条linearlayout作为按钮
	private LinearLayout mTuan_search;
	private TextView mTuan_mytuan_txt;
	private ImageView mTuan_button1;
	private int listOrGridFlag = 0;
	private TextView mTuan_title_textbtn1, mTuan_title_textbtn2,
			mTuan_title_textbtn3;

	private ListView mListView;
	private MyGet myGet = new MyGet();
	private MyJson myJson = new MyJson();
	private List<ShopInfo> list = new ArrayList<ShopInfo>();
	private ShopAdapter mAdapter = null;
	private Button ListBottem = null;
	private int mStart = 1;
	private int mEnd = 5;
	private String url = null;
	private boolean flag = true;
	private boolean listBottemFlag = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tuan);
		initView();
	}

	private void initView() {
		mTuan_search = (LinearLayout) findViewById(R.id.Tuan_search);
		mTuan_mytuan_txt = (TextView) findViewById(R.id.Tuan_mytuan_txt);
		mTuan_button1 = (ImageView) findViewById(R.id.Tuan_button1);
		mTuan_title_textbtn1 = (TextView) findViewById(R.id.Tuan_title_textbtn1);
		mTuan_title_textbtn2 = (TextView) findViewById(R.id.Tuan_title_textbtn2);
		mTuan_title_textbtn3 = (TextView) findViewById(R.id.Tuan_title_textbtn3);
		mListView = (ListView) findViewById(R.id.ShopListView);
		MyOnClickListener myclicklistener = new MyOnClickListener();
		mTuan_search.setOnClickListener(myclicklistener);
		mTuan_mytuan_txt.setOnClickListener(myclicklistener);
		mTuan_button1.setOnClickListener(myclicklistener);
		mTuan_title_textbtn1.setOnClickListener(myclicklistener);
		mTuan_title_textbtn2.setOnClickListener(myclicklistener);
		mTuan_title_textbtn3.setOnClickListener(myclicklistener);
		
		//--------------------
		mAdapter = new ShopAdapter(list, TuanActivity.this);
		ListBottem = new Button(TuanActivity.this);
		ListBottem.setText("点击加载更多");
		ListBottem.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (flag && listBottemFlag) {
					url = Model.TUANURL + "start=" + mStart + "&end=" + mEnd;
					ThreadPoolUtils.execute(new HttpGetThread(hand, url));
					listBottemFlag = false;
				} else if (!listBottemFlag)
					Toast.makeText(TuanActivity.this, "加载中请稍候", 1).show();
			}
		});
		mListView.addFooterView(ListBottem, null, false);
		ListBottem.setVisibility(View.GONE);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(new MainListOnItemClickListener());
		// 拼接字符串操作
		url = Model.SHOPURL + "start=" + mStart + "&end=" + mEnd;
		ThreadPoolUtils.execute(new HttpGetThread(hand, url));

	}

	private class MyOnClickListener implements View.OnClickListener {
		public void onClick(View v) {
			int mID = v.getId();
			if (mID == R.id.Tuan_button1) {
				if (listOrGridFlag == 0) {
					mTuan_button1
							.setImageResource(R.drawable.ic_action_list_mode);
					listOrGridFlag = 1;
				} else if (listOrGridFlag == 1) {
					mTuan_button1
							.setImageResource(R.drawable.ic_action_image_mode);
					listOrGridFlag = 0;
				}
			}
		}

	}
	
	Handler hand = new Handler() {
		public void handleMessage(android.os.Message msg) {
			super.handleMessage(msg);
			if (msg.what == 404) {
				Toast.makeText(TuanActivity.this, "找不到地址", 1).show();
				listBottemFlag = true;
			} else if (msg.what == 100) {
				Toast.makeText(TuanActivity.this, "传输失败", 1).show();
				listBottemFlag = true;
			} else if (msg.what == 200) {
				String result = (String) msg.obj;
				// 在activity当中获取网络交互的数据
				if (result != null) {
					// 1次网络请求返回的数据
					List<ShopInfo> newList = myJson.getShopList(result);
					if (newList != null) {
						if (newList.size() == 5) {
							ListBottem.setVisibility(View.VISIBLE);
							mStart += 5;
							mEnd += 5;
						} else {
							ListBottem.setVisibility(View.GONE);
						}
						for (ShopInfo info : newList) {
							list.add(info);
						}
						mAdapter.notifyDataSetChanged();
						listBottemFlag = true;
						mAdapter.notifyDataSetChanged();
					}
				}
				mAdapter.notifyDataSetChanged();
			}
		};
	};

	private class MainListOnItemClickListener implements OnItemClickListener {
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			Intent intent = new Intent(TuanActivity.this, TuanDetailsActivity.class);
			Bundle bund = new Bundle();
			bund.putSerializable("ShopInfo",list.get(arg2));
			intent.putExtra("value",bund);
			startActivity(intent);
		}
	}

}
