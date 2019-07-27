package com.anjoyo.liuxiaowei;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * ¸ü¶àÄ£¿é
 * */

public class MoreActivity extends Activity {

	private ImageView mMore_button1, mMore_list_likeapp, mMore_list_tuanapp,
			mMore_list_moreapp;
	private LinearLayout mMore_title_btn1, mMore_title_btn2;
	private LinearLayout mMore_list_saoyisao, mMore_list_lishi,
			mMore_list_suishoupai, mMore_list_yiguanbi, mMore_list_gengxin,
			mMore_list_fankui, mMore_list_gaosupengyou,
			mMore_list_tuijianweixin, mMore_list_bangzhu, mMore_list_women,
			mMore_list_dianhua;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_more);
		initView();
	}

	private void initView() {
		mMore_button1 = (ImageView) findViewById(R.id.More_button1);
		mMore_list_likeapp = (ImageView) findViewById(R.id.More_list_likeapp);
		mMore_list_tuanapp = (ImageView) findViewById(R.id.More_list_tuanapp);
		mMore_list_moreapp = (ImageView) findViewById(R.id.More_list_moreapp);
		mMore_title_btn1 = (LinearLayout) findViewById(R.id.More_title_btn1);
		mMore_title_btn2 = (LinearLayout) findViewById(R.id.More_title_btn2);
		mMore_list_saoyisao = (LinearLayout) findViewById(R.id.More_list_saoyisao);
		mMore_list_lishi = (LinearLayout) findViewById(R.id.More_list_lishi);
		mMore_list_suishoupai = (LinearLayout) findViewById(R.id.More_list_suishoupai);
		mMore_list_yiguanbi = (LinearLayout) findViewById(R.id.More_list_yiguanbi);
		mMore_list_gengxin = (LinearLayout) findViewById(R.id.More_list_gengxin);
		mMore_list_fankui = (LinearLayout) findViewById(R.id.More_list_fankui);
		mMore_list_gaosupengyou = (LinearLayout) findViewById(R.id.More_list_gaosupengyou);
		mMore_list_tuijianweixin = (LinearLayout) findViewById(R.id.More_list_tuijianweixin);
		mMore_list_bangzhu = (LinearLayout) findViewById(R.id.More_list_bangzhu);
		mMore_list_women = (LinearLayout) findViewById(R.id.More_list_women);
		mMore_list_dianhua = (LinearLayout) findViewById(R.id.More_list_dianhua);
		MyOnclickListener mOnclickListener = new MyOnclickListener();
		mMore_button1.setOnClickListener(mOnclickListener);
		mMore_list_likeapp.setOnClickListener(mOnclickListener);
		mMore_list_tuanapp.setOnClickListener(mOnclickListener);
		mMore_list_moreapp.setOnClickListener(mOnclickListener);
		mMore_title_btn1.setOnClickListener(mOnclickListener);
		mMore_title_btn2.setOnClickListener(mOnclickListener);
		mMore_list_saoyisao.setOnClickListener(mOnclickListener);
		mMore_list_lishi.setOnClickListener(mOnclickListener);
		mMore_list_suishoupai.setOnClickListener(mOnclickListener);
		mMore_list_yiguanbi.setOnClickListener(mOnclickListener);
		mMore_list_gengxin.setOnClickListener(mOnclickListener);
		mMore_list_fankui.setOnClickListener(mOnclickListener);
		mMore_list_gaosupengyou.setOnClickListener(mOnclickListener);
		mMore_list_tuijianweixin.setOnClickListener(mOnclickListener);
		mMore_list_bangzhu.setOnClickListener(mOnclickListener);
		mMore_list_women.setOnClickListener(mOnclickListener);
		mMore_list_dianhua.setOnClickListener(mOnclickListener);

	}

	private class MyOnclickListener implements View.OnClickListener {
		public void onClick(View v) {
			int mID = v.getId();
		}

	}
}
