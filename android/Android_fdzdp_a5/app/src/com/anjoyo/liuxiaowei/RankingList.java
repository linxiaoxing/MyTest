package com.anjoyo.liuxiaowei;

import java.util.ArrayList;
import java.util.List;

import com.anjoyo.adapter.SearchMoreAdapter;
import com.anjoyo.model.Model;

import android.os.Bundle;
import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
/**
 * 排行榜模块
 * */
public class RankingList extends ActivityGroup {

	private ImageView mShoplist_back;
	private LinearLayout mShoplist_shanghuleixing;
	private ListView mShoplist_toplist;
	private TextView mShoplist_title_txt;
	private ImageView mSearch_city_img;
	private SearchMoreAdapter topadapter = null;
	private boolean toplistview = false;
	// -------上面的tabhost形式的按钮
	private LinearLayout mPaihangbang_top1, mPaihangbang_top2,
			mPaihangbang_top3, mPaihangbang_top4;
	private List<View> list = new ArrayList<View>();// 相当于数据源
	private View view1 = null;
	private View view2 = null;
	private View view3 = null;
	private View view4 = null;
	private android.support.v4.view.ViewPager mViewPager;
	private PagerAdapter pagerAdapter = null;// 数据源和viewpager之间的桥梁

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_paihangbang);
		initView();
	}

	private void initView() {
		mShoplist_back = (ImageView) findViewById(R.id.Shoplist_back);
		mShoplist_shanghuleixing = (LinearLayout) findViewById(R.id.Shoplist_shanghuleixing);
		mShoplist_title_txt = (TextView) findViewById(R.id.Shoplist_title_txt);
		mSearch_city_img = (ImageView) findViewById(R.id.Search_city_img);
		mShoplist_toplist = (ListView) findViewById(R.id.Paihangbang_toplist);
		topadapter = new SearchMoreAdapter(RankingList.this,
				Model.PAIHANGBANG_TOPLIST, R.layout.shop_list2_item);
		mShoplist_toplist.setAdapter(topadapter);
		TopListOnItemclick topListOnItemclick = new TopListOnItemclick();
		mShoplist_toplist.setOnItemClickListener(topListOnItemclick);
		MyOnClickListener myclicklistener = new MyOnClickListener();
		mShoplist_back.setOnClickListener(myclicklistener);
		mShoplist_shanghuleixing.setOnClickListener(myclicklistener);
		// ----找到上面tabhost类型的textView的按钮
		mPaihangbang_top1 = (LinearLayout) findViewById(R.id.Paihangbang_top1);
		mPaihangbang_top2 = (LinearLayout) findViewById(R.id.Paihangbang_top2);
		mPaihangbang_top3 = (LinearLayout) findViewById(R.id.Paihangbang_top3);
		mPaihangbang_top4 = (LinearLayout) findViewById(R.id.Paihangbang_top4);
		mViewPager = (ViewPager) findViewById(R.id.FramePager);

		createView();
		// 写一个内部类pageradapter
		pagerAdapter = new PagerAdapter() {
			// 判断再次添加的view和之前的view 是否是同一个view
			// arg0新添加的view，arg1之前的
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			// 返回数据源长度
			@Override
			public int getCount() {
				return list.size();
			}

			// 销毁被滑动走的view
			/**
			 * ViewGroup 代表了我们的viewpager 相当于activitygroup当中的view容器， 添加之前先移除。
			 * position 第几条数据 Object 被移出的view
			 * */
			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				// 移除view
				container.removeView(list.get(position));
			}

			/**
			 * instantiateItem viewpager要现实的view ViewGroup viewpager position
			 * 第几条数据
			 * */
			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				// 获取view添加到容器当中，并返回
				View v = list.get(position);
				container.addView(v);
				return v;
			}
		};
		// 设置我们的adapter
		mViewPager.setAdapter(pagerAdapter);

		// 设置viewpager界面切换监听,监听viewpager切换第几个界面以及滑动的
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			// arg0 获取 viewpager里面的界面切换到第几个的
			@Override
			public void onPageSelected(int arg0) {
				// 先清除按钮样式
				initBottemBtn();
				// 按照对应的view的tag来判断到底切换到哪个界面。
				// 更改对应的button状态
				int flag = (Integer) list.get((arg0)).getTag();
				if (flag == 0) {
					mPaihangbang_top1
							.setBackgroundResource(R.drawable.yy_list_bkg_line_press);
				} else if (flag == 1) {
					mPaihangbang_top2
							.setBackgroundResource(R.drawable.yy_list_bkg_line_press);
				} else if (flag == 2) {
					mPaihangbang_top3
							.setBackgroundResource(R.drawable.yy_list_bkg_line_press);
				} else if (flag == 3) {
					mPaihangbang_top4
							.setBackgroundResource(R.drawable.yy_list_bkg_line_press);
				}
			}

			/**
			 * 监听页面滑动的 arg0 表示当前滑动的view arg1 表示滑动的百分比 arg2 表示滑动的距离
			 * */
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			/**
			 * 监听滑动状态 arg0 表示我们的滑动状态 0:默认状态 1:滑动状态 2:滑动停止
			 * */
			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});

		mPaihangbang_top1.setOnClickListener(myclicklistener);
		mPaihangbang_top2.setOnClickListener(myclicklistener);
		mPaihangbang_top3.setOnClickListener(myclicklistener);
		mPaihangbang_top4.setOnClickListener(myclicklistener);
	}

	// 把viewpager里面要显示的view实例化出来，并且把相关的view添加到一个list当中
	private void createView() {
		view1 = RankingList.this
				.getLocalActivityManager()
				.startActivity("tuan",
						new Intent(RankingList.this, RankingList_bzrm.class))
				.getDecorView();
		view1.setTag(0);
		list.add(view1);
		view2 = RankingList.this
				.getLocalActivityManager()
				.startActivity("sign",
						new Intent(RankingList.this, RankingList_bzrm.class))
				.getDecorView();
		view2.setTag(1);
		list.add(view2);
		view3 = RankingList.this
				.getLocalActivityManager()
				.startActivity("my",
						new Intent(RankingList.this, RankingList_bzrm.class))
				.getDecorView();
		view3.setTag(2);
		list.add(view3);
		view4 = RankingList.this
				.getLocalActivityManager()
				.startActivity("more",
						new Intent(RankingList.this, RankingList_more.class))
				.getDecorView();
		view4.setTag(3);
		list.add(view4);
	}

	private class MyOnClickListener implements View.OnClickListener {
		public void onClick(View v) {
			int mID = v.getId();
			if (mID == R.id.Shoplist_back) {
				RankingList.this.finish();
			}
			if (mID == R.id.Shoplist_shanghuleixing) {
				if (!toplistview) {
					mSearch_city_img
							.setImageResource(R.drawable.title_arrow_up);
					mShoplist_toplist.setVisibility(View.VISIBLE);
					topadapter.notifyDataSetChanged();
					toplistview = true;
				} else {
					mSearch_city_img.setImageResource(R.drawable.search_city);
					mShoplist_toplist.setVisibility(View.GONE);
					toplistview = false;
				}
			} else {
				mSearch_city_img.setImageResource(R.drawable.search_city);
				mShoplist_toplist.setVisibility(View.GONE);
				toplistview = false;
			}
			switch (mID) {
			case R.id.Paihangbang_top1:
				// //设置我们的viewpager跳转那个界面0这个参数和我们的list相关,相当于list里面的下标
				mViewPager.setCurrentItem(0);
				initBottemBtn();
				mPaihangbang_top1
						.setBackgroundResource(R.drawable.yy_list_bkg_line_press);
				break;
			case R.id.Paihangbang_top2:
				mViewPager.setCurrentItem(1);
				initBottemBtn();
				mPaihangbang_top2
						.setBackgroundResource(R.drawable.yy_list_bkg_line_press);
				break;
			case R.id.Paihangbang_top3:
				mViewPager.setCurrentItem(2);
				initBottemBtn();
				mPaihangbang_top3
						.setBackgroundResource(R.drawable.yy_list_bkg_line_press);
				break;
			case R.id.Paihangbang_top4:
				mViewPager.setCurrentItem(3);
				initBottemBtn();
				mPaihangbang_top4
						.setBackgroundResource(R.drawable.yy_list_bkg_line_press);
				break;
			}
		}

	}

	private class TopListOnItemclick implements OnItemClickListener {
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			topadapter.setSelectItem(arg2);
			mSearch_city_img.setImageResource(R.drawable.search_city);
			mShoplist_title_txt.setText(Model.PAIHANGBANG_TOPLIST[arg2]);
			mShoplist_toplist.setVisibility(View.GONE);
			toplistview = false;
		}
	}

	/**
	 * 初始化控件的颜色
	 * */
	private void initBottemBtn() {
		mPaihangbang_top1
				.setBackgroundResource(R.drawable.paihangbang_toptextbg);
		mPaihangbang_top2
				.setBackgroundResource(R.drawable.paihangbang_toptextbg);
		mPaihangbang_top3
				.setBackgroundResource(R.drawable.paihangbang_toptextbg);
		mPaihangbang_top4
				.setBackgroundResource(R.drawable.paihangbang_toptextbg);
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (toplistview == true) {
				mSearch_city_img.setImageResource(R.drawable.search_city);
				mShoplist_toplist.setVisibility(View.GONE);
				toplistview = false;
			} else {
				RankingList.this.finish();
			}
		}
		return false;
	}
}
