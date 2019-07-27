package com.anjoyo.liuxiaowei;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.anjoyo.adapter.FaceGridAdapter;
import com.anjoyo.info.ShopInfo;
import com.anjoyo.model.Model;
import com.anjoyo.net.ThreadPoolUtils;
import com.anjoyo.thread.HttpPostThread;
import com.anjoyo.utils.SmileyParser;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
/**
 * 店铺详情-签到模块
 * */
public class ShopDetailsCheckinActivity extends Activity {

	private ShopInfo info = null;
	private TextView mShop_details_more_title;
	private ImageView mShoplist_back;
	private EditText mshop_qiandao_edittext1;
	private ImageView mshop_qiandao_biaoqing, mshop_qiandao_addimage;
	private TextView mshop_qiandao_text, mshop_qiandao_OK;
	private RatingBar mshop_qiandao_ratingbar;

	private List<GridView> list = new ArrayList<GridView>();
	private String[] mFaceValue;
	final String arrText1[] = new String[20];
	final String arrText2[] = new String[20];
	final String arrText3[] = new String[20];
	final String arrText4[] = new String[16];
	private ViewPager mViewPager;
	private boolean faceFlag = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_shop_detailsqiandao);
		Intent intent = getIntent();
		Bundle bund = intent.getBundleExtra("value");
		info = (ShopInfo) bund.getSerializable("ShopInfo");
		mFaceValue = this.getResources().getStringArray(
				R.array.default_smiley_texts);
		createView();
		initView();
		initModel();
	}

	private void initView() {
		mShop_details_more_title = (TextView) findViewById(R.id.Shop_details_more_title);
		mShoplist_back = (ImageView) findViewById(R.id.Shoplist_back);
		mShoplist_back.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				ShopDetailsCheckinActivity.this.finish();
			}
		});
		mViewPager = (ViewPager) findViewById(R.id.FaceViewGroup);
		mViewPager.setAdapter(new MyPageAdapter());
		mshop_qiandao_edittext1 = (EditText) findViewById(R.id.shop_qiandao_edittext1);
		mshop_qiandao_biaoqing = (ImageView) findViewById(R.id.shop_qiandao_biaoqing);
		mshop_qiandao_addimage = (ImageView) findViewById(R.id.shop_qiandao_addimage);
		mshop_qiandao_text = (TextView) findViewById(R.id.shop_qiandao_text);
		mshop_qiandao_OK = (TextView) findViewById(R.id.shop_qiandao_OK);
		mshop_qiandao_ratingbar = (RatingBar) findViewById(R.id.shop_qiandao_ratingbar);
		MyOnClickListener myonclick = new MyOnClickListener();
		mshop_qiandao_biaoqing.setOnClickListener(myonclick);
		mshop_qiandao_addimage.setOnClickListener(myonclick);
		mshop_qiandao_OK.setOnClickListener(myonclick);
		mshop_qiandao_ratingbar.setOnTouchListener(new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					event.setAction(MotionEvent.ACTION_MOVE);
				}
				return false;
			}
		});
	}

	private class MyOnClickListener implements View.OnClickListener {
		public void onClick(View v) {
			int mID = v.getId();
			if (mID == R.id.shop_qiandao_OK) {
				addSign();
			} else if (mID == R.id.shop_qiandao_biaoqing) {
				if (faceFlag) {
					mViewPager.setVisibility(View.GONE);
				} else {
					mViewPager.setVisibility(View.VISIBLE);
				}
				faceFlag = !faceFlag;
			}
		}
	}

	private void initModel() {
		mShop_details_more_title.setText(info.getSname());
		for (int i = 0; i < 20; i++) {
			arrText1[i] = mFaceValue[i];
		}
		for (int i = 20; i < 40; i++) {
			arrText2[i - 20] = mFaceValue[i];
		}
		for (int i = 40; i < 60; i++) {
			arrText3[i - 40] = mFaceValue[i];
		}
		for (int i = 60; i < 76; i++) {
			arrText4[i - 60] = mFaceValue[i];
		}
	}

	// 我的签到方法
	private void addSign() {
		String sid = info.getSid();
		String pid = "1";
		String signcontent = mshop_qiandao_edittext1.getText().toString()
				.trim();
		String signlevel = "" + mshop_qiandao_ratingbar.getNumStars();
		String signimage = "";
		String signtime = ""
				+ (new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date()));
		String json = "{\"sid\":\"" + sid + "\"," + "\"pid\":\"" + pid + "\","
				+ "\"signcontent\":\"" + signcontent + "\","
				+ "\"signlevel\":\"" + signlevel + "\"," + "\"signimage\":\""
				+ signimage + "\"," + "\"signtime\":\"" + signtime + "\"}";
		ThreadPoolUtils.execute(new HttpPostThread(hand, Model.SIGNURL, "1",
				json));
	}

	Handler hand = new Handler() {
		public void handleMessage(android.os.Message msg) {
			super.handleMessage(msg);
			if (msg.what == 200) {
				Toast.makeText(ShopDetailsCheckinActivity.this, "签到成功", 1)
						.show();
				finish();
			}
		}
	};

	// 创建viewpager当中的view
	private void createView() {
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		GridView mGrid1 = new GridView(ShopDetailsCheckinActivity.this);
		mGrid1.setLayoutParams(lp);
		mGrid1.setNumColumns(7);
		mGrid1.setAdapter(new FaceGridAdapter(ShopDetailsCheckinActivity.this,
				Model.image1));
		list.add(mGrid1);
		GridView mGrid2 = new GridView(ShopDetailsCheckinActivity.this);
		mGrid2.setLayoutParams(lp);
		mGrid2.setNumColumns(7);
		mGrid2.setAdapter(new FaceGridAdapter(ShopDetailsCheckinActivity.this,
				Model.image2));
		list.add(mGrid2);
		GridView mGrid3 = new GridView(ShopDetailsCheckinActivity.this);
		mGrid3.setLayoutParams(lp);
		mGrid3.setNumColumns(7);
		mGrid3.setAdapter(new FaceGridAdapter(ShopDetailsCheckinActivity.this,
				Model.image3));
		list.add(mGrid3);
		GridView mGrid4 = new GridView(ShopDetailsCheckinActivity.this);
		mGrid4.setLayoutParams(lp);
		mGrid4.setNumColumns(7);
		mGrid4.setAdapter(new FaceGridAdapter(ShopDetailsCheckinActivity.this,
				Model.image4));
		list.add(mGrid4);

		SmileyParser.init(ShopDetailsCheckinActivity.this);
		final SmileyParser parser = SmileyParser.getInstance();
		mGrid1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if (arg2 == 20) {
					Log.e("", "" + mshop_qiandao_edittext1.getText().length());
					mshop_qiandao_edittext1
							.setText(mshop_qiandao_edittext1.getText()
									.subSequence(
											0,
											mshop_qiandao_edittext1.getText()
													.length() - 4));
				} else {
					mshop_qiandao_edittext1.setText(mshop_qiandao_edittext1
							.getText().append(
									parser.addSmileySpans(arrText1[arg2])));
				}
				mshop_qiandao_edittext1.setSelection(mshop_qiandao_edittext1
						.getText().length());
			}
		});
		mGrid2.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if (arg2 == 20) {
					mshop_qiandao_edittext1
							.setText(mshop_qiandao_edittext1.getText()
									.subSequence(
											0,
											mshop_qiandao_edittext1.getText()
													.length() - 4));
				} else {
					mshop_qiandao_edittext1.setText(mshop_qiandao_edittext1
							.getText().append(
									parser.addSmileySpans(arrText2[arg2])));
				}
				mshop_qiandao_edittext1.setSelection(mshop_qiandao_edittext1
						.getText().length());

			}
		});
		mGrid3.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if (arg2 == 20) {
					mshop_qiandao_edittext1
							.setText(mshop_qiandao_edittext1.getText()
									.subSequence(
											0,
											mshop_qiandao_edittext1.getText()
													.length() - 4));
				} else {
					mshop_qiandao_edittext1.setText(mshop_qiandao_edittext1
							.getText().append(
									parser.addSmileySpans(arrText3[arg2])));
				}
				mshop_qiandao_edittext1.setSelection(mshop_qiandao_edittext1
						.getText().length());

			}
		});
		mGrid4.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if (arg2 == 16) {
					mshop_qiandao_edittext1
							.setText(mshop_qiandao_edittext1.getText()
									.subSequence(
											0,
											mshop_qiandao_edittext1.getText()
													.length() - 4));
				} else {
					mshop_qiandao_edittext1.setText(mshop_qiandao_edittext1
							.getText().append(
									parser.addSmileySpans(arrText4[arg2])));
				}
				mshop_qiandao_edittext1.setSelection(mshop_qiandao_edittext1
						.getText().length());

			}
		});
	}

	class MyPageAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(list.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View view = list.get(position);
			container.addView(view);
			return view;
		}

	}

}
