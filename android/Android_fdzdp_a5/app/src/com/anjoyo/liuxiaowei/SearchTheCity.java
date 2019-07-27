package com.anjoyo.liuxiaowei;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * 搜全城模块
 * */
public class SearchTheCity extends Activity {

	private ImageView mSouquancheng_back;
	private TextView mSouquancheng_moresearch, mSouquancheng_text1,
			mSouquancheng_text2, mSouquancheng_text3, mSouquancheng_text4,
			mSouquancheng_text5, mSouquancheng_text6, mSouquancheng_text7,
			mSouquancheng_text8, mSouquancheng_text9, mSouquancheng_text10,
			mSouquancheng_text11, mSouquancheng_text12, mSouquancheng_text13,
			mSouquancheng_text14, mSouquancheng_text15, mSouquancheng_text16,
			mSouquancheng_text17, mSouquancheng_text18, mSouquancheng_text19,
			mSouquancheng_text20, mSouquancheng_text21, mSouquancheng_text22;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_sou_quan_cheng);
		initView();
	}

	private void initView() {
		mSouquancheng_back = (ImageView) findViewById(R.id.Souquancheng_back);
		mSouquancheng_moresearch = (TextView) findViewById(R.id.Souquancheng_moresearch);
		mSouquancheng_text1 = (TextView) findViewById(R.id.Souquancheng_text1);
		mSouquancheng_text2 = (TextView) findViewById(R.id.Souquancheng_text2);
		mSouquancheng_text3 = (TextView) findViewById(R.id.Souquancheng_text3);
		mSouquancheng_text4 = (TextView) findViewById(R.id.Souquancheng_text4);
		mSouquancheng_text5 = (TextView) findViewById(R.id.Souquancheng_text5);
		mSouquancheng_text6 = (TextView) findViewById(R.id.Souquancheng_text6);
		mSouquancheng_text7 = (TextView) findViewById(R.id.Souquancheng_text7);
		mSouquancheng_text8 = (TextView) findViewById(R.id.Souquancheng_text8);
		mSouquancheng_text9 = (TextView) findViewById(R.id.Souquancheng_text9);
		mSouquancheng_text10 = (TextView) findViewById(R.id.Souquancheng_text10);
		mSouquancheng_text11 = (TextView) findViewById(R.id.Souquancheng_text11);
		mSouquancheng_text12 = (TextView) findViewById(R.id.Souquancheng_text12);
		mSouquancheng_text13 = (TextView) findViewById(R.id.Souquancheng_text13);
		mSouquancheng_text14 = (TextView) findViewById(R.id.Souquancheng_text14);
		mSouquancheng_text15 = (TextView) findViewById(R.id.Souquancheng_text15);
		mSouquancheng_text16 = (TextView) findViewById(R.id.Souquancheng_text16);
		mSouquancheng_text17 = (TextView) findViewById(R.id.Souquancheng_text17);
		mSouquancheng_text18 = (TextView) findViewById(R.id.Souquancheng_text18);
		mSouquancheng_text19 = (TextView) findViewById(R.id.Souquancheng_text19);
		mSouquancheng_text20 = (TextView) findViewById(R.id.Souquancheng_text20);
		mSouquancheng_text21 = (TextView) findViewById(R.id.Souquancheng_text21);
		mSouquancheng_text22 = (TextView) findViewById(R.id.Souquancheng_text22);
		MyOnClickListener myonlicklitener = new MyOnClickListener();
		mSouquancheng_back.setOnClickListener(myonlicklitener);
		mSouquancheng_moresearch.setOnClickListener(myonlicklitener);
		mSouquancheng_text1.setOnClickListener(myonlicklitener);
		mSouquancheng_text2.setOnClickListener(myonlicklitener);
		mSouquancheng_text3.setOnClickListener(myonlicklitener);
		mSouquancheng_text4.setOnClickListener(myonlicklitener);
		mSouquancheng_text5.setOnClickListener(myonlicklitener);
		mSouquancheng_text6.setOnClickListener(myonlicklitener);
		mSouquancheng_text7.setOnClickListener(myonlicklitener);
		mSouquancheng_text8.setOnClickListener(myonlicklitener);
		mSouquancheng_text9.setOnClickListener(myonlicklitener);
		mSouquancheng_text10.setOnClickListener(myonlicklitener);
		mSouquancheng_text11.setOnClickListener(myonlicklitener);
		mSouquancheng_text12.setOnClickListener(myonlicklitener);
		mSouquancheng_text13.setOnClickListener(myonlicklitener);
		mSouquancheng_text14.setOnClickListener(myonlicklitener);
		mSouquancheng_text15.setOnClickListener(myonlicklitener);
		mSouquancheng_text16.setOnClickListener(myonlicklitener);
		mSouquancheng_text17.setOnClickListener(myonlicklitener);
		mSouquancheng_text18.setOnClickListener(myonlicklitener);
		mSouquancheng_text19.setOnClickListener(myonlicklitener);
		mSouquancheng_text20.setOnClickListener(myonlicklitener);
		mSouquancheng_text21.setOnClickListener(myonlicklitener);
		mSouquancheng_text22.setOnClickListener(myonlicklitener);
	}

	// 监听事件
	private class MyOnClickListener implements View.OnClickListener {
		public void onClick(View v) {
			int mID = v.getId();
			if (mID == R.id.Souquancheng_back) {
				SearchTheCity.this.finish();
			}
		}
	}
}
