package com.anjoyo.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.anjoyo.info.ShopInfo;
import com.anjoyo.liuxiaowei.R;
import com.anjoyo.model.Model;
import com.anjoyo.utils.LoadImg;
import com.anjoyo.utils.LoadImg.ImageDownloadCallBack;

/**
 * 商铺列表的适配器
 * @author 苦涩
 *
 */

public class ShopAdapter extends BaseAdapter {

	private List<ShopInfo> list;
	private Context ctx;
	private LoadImg loadImg;

	public ShopAdapter(List<ShopInfo> list, Context ctx) {
		this.list = list;
		this.ctx = ctx;
		// 实例化获取图片的类
		loadImg = new LoadImg(ctx);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(final int arg0, View arg1, ViewGroup arg2) {
		final Holder hold;
		if (arg1 == null) {
			hold = new Holder();
			arg1 = View.inflate(ctx, R.layout.item_shop, null);
			hold.mTitle = (TextView) arg1.findViewById(R.id.ShopItemTextView);
			hold.mImage = (ImageView) arg1.findViewById(R.id.ShopItemImage);
			hold.mMoney = (TextView) arg1.findViewById(R.id.ShopItemMoney);
			hold.mAddress = (TextView) arg1.findViewById(R.id.ShopItemAddress);
			hold.mStytle = (TextView) arg1.findViewById(R.id.ShopItemStytle);
			hold.mStar = (ImageView) arg1.findViewById(R.id.ShopItemStar);
			hold.mTuan = (ImageView) arg1.findViewById(R.id.ShopItemTuan);
			hold.mQuan = (ImageView) arg1.findViewById(R.id.ShopItemQuan);
			hold.mDing = (ImageView) arg1.findViewById(R.id.ShopItemDing);
			hold.mCard = (ImageView) arg1.findViewById(R.id.ShopItemCard);

			arg1.setTag(hold);
		} else {
			hold = (Holder) arg1.getTag();
		}
		hold.mTitle.setText(list.get(arg0).getSname());
		hold.mImage.setTag(Model.SHOPLISTIMGURL + list.get(arg0).getIname());
		hold.mMoney.setText(list.get(arg0).getSmoney());
		hold.mAddress.setText(list.get(arg0).getSaddress());
		hold.mStytle.setText(list.get(arg0).getStype());
		hold.mTuan.setVisibility(View.GONE);
		hold.mQuan.setVisibility(View.GONE);
		hold.mDing.setVisibility(View.GONE);
		hold.mCard.setVisibility(View.GONE);
		if (list.get(arg0).getSflag_tuan().equals("1")) {
			hold.mTuan.setVisibility(View.VISIBLE);
		}
		if (list.get(arg0).getSflag_quan().equals("1")) {
			hold.mQuan.setVisibility(View.VISIBLE);
		}
		if (list.get(arg0).getSflag_ding().equals("1")) {
			hold.mDing.setVisibility(View.VISIBLE);
		}
		if (list.get(arg0).getSflag_ka().equals("1")) {
			hold.mCard.setVisibility(View.VISIBLE);
		}

		int slevel = Integer.valueOf(list.get(arg0).getSlevel());
		switch (slevel) {
		case 0:
			hold.mStar.setImageResource(R.drawable.star0);
			break;
		case 1:
			hold.mStar.setImageResource(R.drawable.star1);
			break;
		case 2:
			hold.mStar.setImageResource(R.drawable.star2);
			break;
		case 3:
			hold.mStar.setImageResource(R.drawable.star3);
			break;
		case 4:
			hold.mStar.setImageResource(R.drawable.star4);
			break;
		case 5:
			hold.mStar.setImageResource(R.drawable.star5);
			break;
		}

		// 设置默认显示的图片
		hold.mImage.setImageResource(R.drawable.shop_photo_frame);
		// 网络获取图片
		Bitmap bit = loadImg.loadImage(hold.mImage, Model.SHOPLISTIMGURL
				+ list.get(arg0).getIname(), new ImageDownloadCallBack() {
			@Override
			public void onImageDownload(ImageView imageView, Bitmap bitmap) {
				// 网络交互时回调进来防止错位
				if (hold.mImage.getTag().equals(
						Model.SHOPLISTIMGURL + list.get(arg0).getIname())) {
					// 设置网络下载回来图片显示
					hold.mImage.setImageBitmap(bitmap);
				}
			}
		});
		// 从本地获取的
		if (bit != null) {
			// 设置缓存图片显示
			hold.mImage.setImageBitmap(bit);
		}

		return arg1;
	}

	static class Holder {
		TextView mTitle, mMoney, mAddress, mStytle;
		ImageView mImage, mStar, mTuan, mQuan, mDing, mCard;
	}

}
