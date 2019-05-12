package com.example.goodscenter.widget

import android.app.Activity
import android.content.Context
import android.text.Editable
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.widget.*
import com.eightbitlab.rxbus.Bus
import com.example.chen.baselibrary.ext.Onclick
import com.example.chen.baselibrary.ext.loadUrl
import com.example.chen.baselibrary.widgets.DefaultTextWatcher
import com.example.goodscenter.R
import com.example.goodscenter.common.GoodsConstant
import com.example.goodscenter.event.AddCartEvent
import com.example.goodscenter.event.SkuChangedEvent
import com.example.goodscenter.getEditText
import com.kotlin.base.utils.YuanFenConverter
import com.kotlin.goods.data.protocol.GoodsSku
import kotlinx.android.synthetic.main.layout_sku_pop.view.*

/*
    商品SKU弹层
 */
class GoodsSkuPopView(context: Activity) : PopupWindow(context), View.OnClickListener {
    //根视图
    private val mRootView: View
    private val mContext: Context
    private val mSkuViewList = arrayListOf<SkuView>()

    init {
        mContext = context
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        mRootView = inflater.inflate(R.layout.layout_sku_pop, null)

        initView()

        // 设置SelectPicPopupWindow的View
        this.contentView = mRootView
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.width = LayoutParams.MATCH_PARENT
        // 设置SelectPicPopupWindow弹出窗体的高
        this.height = LayoutParams.MATCH_PARENT
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.isFocusable = true
        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.animationStyle = R.style.AnimBottom
        background.alpha = 150
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mRootView.setOnTouchListener { _, event ->
            //   val height = mRootView.findViewById(R.id.mPopView).top
            val y = event.y.toInt()
            if (event.action == MotionEvent.ACTION_UP) {
                if (y < height) {
                    dismiss()
                }
            }
            true
        }


    }

    /*
        初始化视图
     */
    private fun initView() {
        mRootView.mCloseIv.Onclick(this)
        mRootView.mAddCartBtn.Onclick(this)
        mRootView.mSkuCountBtn.setCurrentNumber(1)
        mRootView.mSkuCountBtn.getEditText().addTextChangedListener(
                object : DefaultTextWatcher() {
                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        Bus.send(SkuChangedEvent())
                    }
                }
        )
        mRootView.mAddCartBtn.Onclick {
            Bus.send(AddCartEvent())
            dismiss()
        }
    }

    /*
        设置商品图标
     */
    fun setGoodsIcon(text: String) {
        mRootView.mGoodsIconIv.loadUrl(text)
    }

    /*
        设置商品价格
     */
    fun setGoodsPrice(text: Long) {
        mRootView.mGoodsPriceTv.text = YuanFenConverter.changeF2YWithUnit(text)
    }

    /*
        设置商品编号
     */
    fun setGoodsCode(text: String) {
        mRootView.mGoodsCodeTv.text = "商品编号:" + text
    }

    /*
        设置商品SKU
     */
    fun setSkuData(list: List<GoodsSku>) {
        for (goodSku in list) {
            val skuView = SkuView(mContext)
            skuView.setSkuData(goodSku)

            mSkuViewList.add(skuView)
            mRootView.mSkuView.addView(skuView)
        }
    }

    /*
        获取选中的SKU
     */
    fun getSelectSku(): String {
        var skuInfo = ""
        for (skuView in mSkuViewList) {
            skuInfo += skuView.getSkuInfo().split(GoodsConstant.SKU_SEPARATOR)[1] + GoodsConstant.SKU_SEPARATOR
        }
        return skuInfo.take(skuInfo.length - 1)//刪除最后一个分隔
    }

    /*
        获取商品数量
     */
    fun getSelectCount() = mRootView.mSkuCountBtn.number

    override fun onClick(v: View) {
        when (v.id) {
            R.id.mCloseIv -> dismiss()
            R.id.mAddCartBtn -> {
                dismiss()
            }
        }
    }

}
