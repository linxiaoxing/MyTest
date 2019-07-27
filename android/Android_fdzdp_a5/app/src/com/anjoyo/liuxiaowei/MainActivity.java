package com.anjoyo.liuxiaowei;

import com.anjoyo.adapter.ViewPagerAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;

/**
 * 软件新手指引界面
 * */

public class MainActivity extends FragmentActivity {

	private ViewPager mViewPager;// 定义一个自己的viewpager

	// ViewPager 和我们的listview差不多也要一个适配器

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		mViewPager = (ViewPager) findViewById(R.id.MyViewPager);
		ViewPagerAdapter myAdapter = new ViewPagerAdapter(
				this.getSupportFragmentManager(), MainActivity.this);
		mViewPager.setAdapter(myAdapter);
	}

	@Override
	protected void onStop() {
		finish();
		super.onStop();
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {

		}
		return true;
	}
}
