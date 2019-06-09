package com.example.kotlinshoptest.goodscenter.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.launcher.ARouter
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.example.baselibrary.ui.fragment.BaseMvpFragment
import com.example.baselibrary.utils.AppPrefsUtils
import com.example.kotlinshoptest.goodscenter.presenter.CartListPresenter
import com.example.kotlinshoptest.goodscenter.presenter.view.CartListView
import com.example.kotlinshoptest.goodscenter.ui.adapter.CartGoodsAdapter
import com.example.kotlinshoptest.R
import com.example.kotlinshoptest.baselibrary.ext.OnClick
import com.example.kotlinshoptest.baselibrary.ext.setVisible
import com.example.kotlinshoptest.goodscenter.UpdateCartSizeEvent
import com.example.kotlinshoptest.goodscenter.YuanFenConverter
import com.example.kotlinshoptest.goodscenter.common.GoodsConstant
import com.example.kotlinshoptest.goodscenter.event.CartAllCheckedEvent
import com.example.kotlinshoptest.goodscenter.event.UpdateTotalPriceEvent
import com.example.kotlinshoptest.goodscenter.injection.component.DaggerCartComponent
import com.example.kotlinshoptest.goodscenter.injection.module.CartModule
import com.example.kotlinshoptest.provider.common.ProviderConstant
import com.example.kotlinshoptest.provider.router.RouterPath
import com.kennyc.view.MultiStateView
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
         initView()
         initObserve()
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

    /*
        初始化视图和事件
     */
    private fun initView() {
        mCartGoodsRv.layoutManager = LinearLayoutManager(context)
        mAdapter = CartGoodsAdapter(context)
        mCartGoodsRv.adapter = mAdapter
        //全选按钮事件
        mAllCheckedCb.OnClick {
            for (item in mAdapter.dataList) {
                item.isSelected = mAllCheckedCb.isChecked
            }
            mAdapter.notifyDataSetChanged()
            updateTotalPrice()
        }
        mHeaderBar.getRightView().OnClick {
            refreshEditStatus()
        }
        //删除按钮事件
        mDeleteBtn.OnClick {
            val cartIdList: MutableList<Int> = arrayListOf()
            mAdapter.dataList.filter {
                it.isSelected
            }.mapTo(cartIdList) { it.id }
            if (cartIdList.size == 0) {
                toast("请选择需要删除的数据")
            } else {
                mPresenter.deleteCartList(cartIdList)
            }
        }

        //结算按钮事件
        mSettleAccountsBtn.OnClick{
            val cartGoodsList: MutableList<CartGoods> = arrayListOf()
            mAdapter.dataList.filter {
                it.isSelected
            }.mapTo(cartGoodsList) { it }
            if (cartGoodsList.size == 0) {
                toast("请选择需要提交的数据")
            } else {
                mPresenter.submitCart(cartGoodsList, mTotalPrice)
            }
        }
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
        DaggerCartComponent.builder().activityComponent(mActivityComponent).cartModule(CartModule()).build().inject(this)
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

        if (result != null && result.size > 0) {
            mAdapter.setData(result)
            mHeaderBar.getRightView().setVisible(true)
            mAllCheckedCb.isChecked = false
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_CONTENT
        } else {
            mHeaderBar.getRightView().setVisible(false)
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_EMPTY
        }
        //本地存储并发送事件刷新UI
        AppPrefsUtils.putInt(GoodsConstant.SP_CART_SIZE, result?.size ?: 0)
        Bus.send(UpdateCartSizeEvent())
        updateTotalPrice()
    }

    override fun onDeleteCartListResult(result: Boolean) {
        toast("删除成功")
        loadData()
    }

    /**
     * 提交购物车回调
     */
    override fun onSubmitCartListResult(result: Int) {
        ARouter.getInstance().build(RouterPath.OrderCenter.PATH_ORDER_CONFIRM)
                .withInt(ProviderConstant.KEY_ORDER_ID,result)
                .navigation()
    }


    /**
     *   设置Back是否可见
     */
    fun setBackVisiable(isVisible: Boolean) {
        mHeaderBar.getLeftView().setVisible(isVisible)
    }
}