package com.anjoyo.adapter;

import com.anjoyo.liuxiaowei.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * 表情的GridView的适配器
 * @author 苦涩
 *</BR> </BR> By：苦涩 </BR> 联系作者：QQ 534429149
 */

public class FaceGridAdapter extends BaseAdapter {

	private Context ctx;
	private int[] mValue;

	public FaceGridAdapter(Context ctx, int[] mValue) {
		this.ctx = ctx;
		this.mValue = mValue;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mValue.length;
	}

	@Override
	public Object getItem(int arg0) {
		return mValue[arg0];
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		Holder hold;
		if (arg1 == null) {
			hold = new Holder();
			arg1 = View.inflate(ctx, R.layout.griditem, null);
			hold.mImg = (ImageView) arg1.findViewById(R.id.imageView1);
			arg1.setTag(hold);
		} else {
			hold = (Holder) arg1.getTag();
		}
		hold.mImg.setImageResource(mValue[arg0]);
		return arg1;
	}

	private static class Holder {
		ImageView mImg;
	}

}
