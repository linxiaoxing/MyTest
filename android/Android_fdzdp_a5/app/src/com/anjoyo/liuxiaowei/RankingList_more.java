package com.anjoyo.liuxiaowei;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
/**
 * 排行榜-更多模块
 * </BR> </BR> By：苦涩 </BR> 联系作者：QQ 534429149
 * */
public class RankingList_more extends Activity {

	private TextView mpaihangbang_more_bzrm, mpaihangbang_more_zjct,
			mpaihangbang_more_kwzj, mpaihangbang_more_hjzj,
			mpaihangbang_more_fwzj, mpaihangbang_more_zjjr;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_paihangbang_more);
		initView();
	}

	private void initView() {
		mpaihangbang_more_bzrm = (TextView) findViewById(R.id.paihangbang_more_bzrm);
		mpaihangbang_more_zjct = (TextView) findViewById(R.id.paihangbang_more_zjct);
		mpaihangbang_more_kwzj = (TextView) findViewById(R.id.paihangbang_more_kwzj);
		mpaihangbang_more_hjzj = (TextView) findViewById(R.id.paihangbang_more_hjzj);
		mpaihangbang_more_fwzj = (TextView) findViewById(R.id.paihangbang_more_fwzj);
		mpaihangbang_more_zjjr = (TextView) findViewById(R.id.paihangbang_more_zjjr);
		MyOncliclistener myonclick = new MyOncliclistener();
		mpaihangbang_more_bzrm.setOnClickListener(myonclick);
		mpaihangbang_more_zjct.setOnClickListener(myonclick);
		mpaihangbang_more_kwzj.setOnClickListener(myonclick);
		mpaihangbang_more_hjzj.setOnClickListener(myonclick);
		mpaihangbang_more_fwzj.setOnClickListener(myonclick);
		mpaihangbang_more_zjjr.setOnClickListener(myonclick);
	}

	private class MyOncliclistener implements View.OnClickListener {
		public void onClick(View v) {
			int mID = v.getId();
		}
	}
}
