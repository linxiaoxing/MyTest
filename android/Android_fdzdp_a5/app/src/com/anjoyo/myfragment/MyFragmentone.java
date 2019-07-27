package com.anjoyo.myfragment;

import com.anjoyo.liuxiaowei.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("ValidFragment")
public class MyFragmentone extends Fragment {

	private Context ctx;// 从activity当中得到的上下文

	@SuppressLint("ValidFragment")
	public MyFragmentone(Context ctx) {
		super();
		this.ctx = ctx;
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		// 初始化fragment时使用
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// fragment创建时使用
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// fragment创建view时使用
		// 返回的是一个view
		/**
		 * LayoutInflater inflater 找我们的fragmentxml时实用的 ViewGroup
		 * 使用inflater时宽高相对条件 bundler 可以通过我们的bundle在fragment创建view时传递参数
		 * */
		View view = null;
		view = View.inflate(ctx, R.layout.fragment_my01, null);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		// activity创建时使用

	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		// 暂停
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		// activity onresume 时使用
	}

	@Override
	public void onStop() {
		// activity onStop()使用
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		// fragment销毁view时进入
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		// activity销毁
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		// fragment 被删除时进入
		super.onDetach();
	}
}
