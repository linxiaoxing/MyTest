package com.example.kotlinshoptest.goodscenter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.example.baselibrary.ui.fragment.BaseMvpFragment
import com.example.kotlinshoptest.goodscenter.presenter.CartListPresenter
import com.example.kotlinshoptest.goodscenter.presenter.view.CartListView
import com.example.kotlinshoptest.goodscenter.ui.adapter.CartGoodsAdapter
import com.example.kotlinshoptest.R
import com.example.kotlinshoptest.baselibrary.ext.setVisible
import com.example.kotlinshoptest.goodscenter.YuanFenConverter
import com.example.kotlinshoptest.goodscenter.event.CartAllCheckedEvent
import com.example.kotlinshoptest.goodscenter.event.UpdateTotalPriceEvent
import com.example.kotlinshoptest.goodscenter.injection.module.CartModule
import com.kotlin.goods.data.protocol.CartGoods
import kotlinx.android.synthetic.main.fragment_cart.*
import org.jetbrains.anko.support.v4.toast

/*
    购物车 Fragment
 */
class CartFragment : BaseMvpFragment<CartListPresenter>(), CartListView {

    private lateinit var mAdapter: CartGoodsAdapter
    private var mTotalPrice: Long = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_cart, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // initView()
        // initObserve()
    }

    /**
     *  注册监听
     */
    private fun initObserve() {
        Bus.observe<CartAllCheckedEvent>().subscribe { t: CartAllCheckedEvent ->
            run {
                mAllCheckedCb.isChecked = t.isAllChecked
            }
        }.registerInBus(this)

        Bus.observe<UpdateTotalPriceEvent>().subscribe {
            updateTotalPrice()
        }.registerInBus(this)
    }

    /**
     * 取消监听
     */
    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }

    /*
        加载数据
     */
    override fun onStart() {
        super.onStart()
        loadData()
    }

    /**
     *  更新总价
     */
    private fun updateTotalPrice() {
        mTotalPrice = mAdapter.dataList
                .filter { it.isSelected }
                .map { it.goodsCount * it.goodsPrice }
                .sum()
        mTotalPriceTv.text = "合计:${YuanFenConverter.changeF2YWithUnit(mTotalPrice)}"
    }

    /*
     Dagger注册
  */
    override fun injectComponent() {
        //DaggerCartComponent.builder().activityComponent(mActivityComponent).cartModule(CartModule()).build().inject(this)
        mPresenter.mView = this
    }

    /*
        加载数据
     */
    private fun loadData() {
       // mMultiStateView.startLoading()
        mPresenter.getCartList()
    }

    /**
     * 刷新是否为编辑状态
     */
    private fun refreshEditStatus() {
        val isEditStatus = getString(R.string.common_edit) == mHeaderBar.getRightText()
        mTotalPriceTv.setVisible(isEditStatus.not())
        mSettleAccountsBtn.setVisible(isEditStatus.not())
        mDeleteBtn.setVisible(isEditStatus)
        mHeaderBar.getRightView().text = if (isEditStatus) getString(R.string.common_complete) else getString(R.string.common_edit)
    }

    /*
      获取购物车列表回调
   */
    override fun onGetCartListResult(result: MutableList<CartGoods>?) {


    }

    override fun onDeleteCartListResult(result: Boolean) {
        toast("删除成功")
        loadData()
    }

    /**
     * 提交购物车回调
     */
    override fun onSubmitCartListResult(result: Int) {}

}