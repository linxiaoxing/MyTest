package com.anjoyo.liuxiaowei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

import com.anjoyo.adapter.SearchMainAdapter;
import com.anjoyo.adapter.SearchMoreAdapter;
import com.anjoyo.model.Model;
/**
 * 查找-更多模块
 * */
public class SearchMoreActivity extends Activity {

	private ListView mSearch_more_mainlist;
	private ListView mSearch_more_morelist;
	private ImageView mSearch_more_back;
	private List<Map<String, Object>> mainList;
	SearchMainAdapter mainAdapter;
	SearchMoreAdapter moreAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_search_more);
		initModle();
		initView();
	}

	private class MainOnItemClick implements OnItemClickListener {
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			initAdapter(Model.MORELISTTXT[arg2]);
			mainAdapter.setSelectItem(arg2);
			mainAdapter.notifyDataSetChanged();
		}

	}

	private void initView() {
		mSearch_more_back = (ImageView) findViewById(R.id.Search_more_back);
		mSearch_more_back.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				SearchMoreActivity.this.finish();
			}
		});
		mSearch_more_mainlist = (ListView) findViewById(R.id.Search_more_mainlist);
		mSearch_more_morelist = (ListView) findViewById(R.id.Search_more_morelist);
		mainAdapter = new SearchMainAdapter(SearchMoreActivity.this, mainList);
		mainAdapter.setSelectItem(0);
		mSearch_more_mainlist.setAdapter(mainAdapter);
		MainOnItemClick mainclick = new MainOnItemClick();
		mSearch_more_mainlist.setOnItemClickListener(mainclick);
		// mSearch_more_mainlist.setChoiceMode(ListView.CHOICE_MODE_SINGLE);//
		// 一定要设置这个属性，否则ListView不会刷新
		initAdapter(Model.MORELISTTXT[0]);
	}

	private void initAdapter(String[] array) {
		moreAdapter = new SearchMoreAdapter(SearchMoreActivity.this, array);
		mSearch_more_morelist.setAdapter(moreAdapter);
		moreAdapter.notifyDataSetChanged();
	}

	private void initModle() {
		mainList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < Model.LISTVIEWIMG.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("img", Model.LISTVIEWIMG[i]);
			map.put("txt", Model.LISTVIEWTXT[i]);
			mainList.add(map);
		}
	}
}
