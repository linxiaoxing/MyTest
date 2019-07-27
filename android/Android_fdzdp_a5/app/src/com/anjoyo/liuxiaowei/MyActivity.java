package com.anjoyo.liuxiaowei;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 我的模块
 * */

public class MyActivity extends Activity {

	private TextView mMy_register, mMy_login, mMy_address, mMy_checkin,
			mMy_comment, mMy_photo;
	// 信封
	private LinearLayout mMy_messagebtn;
	// listview类型的linearlayout按钮
	private LinearLayout mMy_list_tuangou, mMy_list_huiyuanka, mMy_list_yuding,
			mMy_list_menpiao, mMy_list_jiudian, mMy_list_caogao,
			mMy_list_shanghushoucang, mMy_list_tuangoushoucang,
			mMy_list_guanzhu, mMy_list_fensi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
		initView();
	}

	private void initView() {
		mMy_register = (TextView) findViewById(R.id.My_register);
		mMy_login = (TextView) findViewById(R.id.My_login);
		mMy_address = (TextView) findViewById(R.id.My_address);
		mMy_checkin = (TextView) findViewById(R.id.My_checkin);
		mMy_comment = (TextView) findViewById(R.id.My_comment);
		mMy_photo = (TextView) findViewById(R.id.My_photo);
		mMy_messagebtn = (LinearLayout) findViewById(R.id.My_messagebtn);
		mMy_list_tuangou = (LinearLayout) findViewById(R.id.My_list_tuangou);
		mMy_list_huiyuanka = (LinearLayout) findViewById(R.id.My_list_huiyuanka);
		mMy_list_yuding = (LinearLayout) findViewById(R.id.My_list_yuding);
		mMy_list_menpiao = (LinearLayout) findViewById(R.id.My_list_menpiao);
		mMy_list_jiudian = (LinearLayout) findViewById(R.id.My_list_jiudian);
		mMy_list_caogao = (LinearLayout) findViewById(R.id.My_list_caogao);
		mMy_list_shanghushoucang = (LinearLayout) findViewById(R.id.My_list_shanghuhushoucang);
		mMy_list_tuangoushoucang = (LinearLayout) findViewById(R.id.My_list_tuangoushoucang);
		mMy_list_guanzhu = (LinearLayout) findViewById(R.id.My_list_guanzhu);
		mMy_list_fensi = (LinearLayout) findViewById(R.id.My_list_fensi);
		MyOnclickListener mOnclickListener = new MyOnclickListener();
		mMy_register.setOnClickListener(mOnclickListener);
		mMy_login.setOnClickListener(mOnclickListener);
		mMy_address.setOnClickListener(mOnclickListener);
		mMy_checkin.setOnClickListener(mOnclickListener);
		mMy_comment.setOnClickListener(mOnclickListener);
		mMy_photo.setOnClickListener(mOnclickListener);
		mMy_messagebtn.setOnClickListener(mOnclickListener);
		mMy_list_tuangou.setOnClickListener(mOnclickListener);
		mMy_list_huiyuanka.setOnClickListener(mOnclickListener);
		mMy_list_yuding.setOnClickListener(mOnclickListener);
		mMy_list_menpiao.setOnClickListener(mOnclickListener);
		mMy_list_jiudian.setOnClickListener(mOnclickListener);
		mMy_list_caogao.setOnClickListener(mOnclickListener);
		mMy_list_shanghushoucang.setOnClickListener(mOnclickListener);
		mMy_list_tuangoushoucang.setOnClickListener(mOnclickListener);
		mMy_list_guanzhu.setOnClickListener(mOnclickListener);
		mMy_list_fensi.setOnClickListener(mOnclickListener);
	}

	private class MyOnclickListener implements View.OnClickListener {
		public void onClick(View v) {
			int mID = v.getId();
			switch (mID) {
			case R.id.My_register:
				Intent intent = new Intent(MyActivity.this,
						RegistrationActivity.class);
				startActivity(intent);
				break;
			case R.id.My_login:
				Intent intent2 = new Intent(MyActivity.this,
						LoginActivity.class);
				startActivity(intent2);
				break;
			}
		}

	}
}
