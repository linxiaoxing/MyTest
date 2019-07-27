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
 * �������ָ������
 * */

public class MainActivity extends FragmentActivity {

	private ViewPager mViewPager;// ����һ���Լ���viewpager

	// ViewPager �����ǵ�listview���ҲҪһ��������

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
