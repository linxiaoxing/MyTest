package com.example.ordercenter.ui.act

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.example.chen.baselibrary.ext.Onclick
import com.example.chen.baselibrary.ext.setVisible
import com.example.chen.baselibrary.ui.activity.BaseMvpActivity
import com.example.chen.provider.router.RouterPath
import com.example.ordercenter.R
import com.example.ordercenter.presenter.OrderConfirmPresenter
import com.example.ordercenter.ui.adapter.OrderGoodsAdapter
import com.kotlin.base.utils.YuanFenConverter
import com.kotlin.order.data.protocol.Order
import com.kotlin.order.event.SelectAddressEvent
import com.kotlin.order.injection.component.DaggerOrderComponent
import com.kotlin.order.injection.module.OrderModule
import com.kotlin.order.presenter.view.OrderConfirmView
import com.kotlin.provider.common.ProviderConstant
import kotlinx.android.synthetic.main.activity_order_confirm.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * 订单确认页
 */
@Route(path = RouterPath.OrderCenter.PATH_ORDER_CONFIRM)
class OrderConfirmActivity : BaseMvpActivity<OrderConfirmPresenter>(), OrderConfirmView {
    private lateinit var mAdapter: OrderGoodsAdapter
    @Autowired(name = ProviderConstant.KEY_ORDER_ID)
    @JvmField
    var mOrderId: Int = 0;
    private var mCurrentOrder: Order? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_confirm)
        ARouter.getInstance().inject(this)
        initView()
        initObserve()
        loadData()
    }

    private fun loadData() {
       // mOrderId = intent.getIntExtra(ProviderConstant.KEY_ORDER_ID, -1)
        mPresenter.getOrderById(mOrderId)
    }

    private fun initView() {
        mSelectShipTv.Onclick {
            startActivity<ShipAddressActivity>()
        }
        mShipView.Onclick {
            startActivity<ShipAddressActivity>()
        }
        mSubmitOrderBtn.Onclick {
            mCurrentOrder?.let {
                mPresenter.submitOrder(it)
            }
        }
        //订单中商品列表
        mOrderGoodsRv.layoutManager = LinearLayoutManager(this)
        mAdapter = OrderGoodsAdapter(this)
        mOrderGoodsRv.adapter = mAdapter
    }

    /**
     *  初始化选择收货人事件监听
     */
    private fun initObserve() {
        Bus.observe<SelectAddressEvent>()
                .subscribe { t: SelectAddressEvent ->
                    run {
                        mCurrentOrder?.let {
                            it.shipAddress = t.address
                        }
                        updateAddressView()
                    }
                }
                .registerInBus(this)

    }

    /**
     * 根据是否有收货人信息，更新视图
     */
    private fun updateAddressView() {
        mCurrentOrder?.let {
            if (it.shipAddress == null) {
                mSelectShipTv.setVisible(true)
                mShipView.setVisible(false)
            } else {
                mSelectShipTv.setVisible(false)
                mShipView.setVisible(true)
                mShipNameTv.text = it.shipAddress!!.shipUserName + "  " +
                        it.shipAddress!!.shipUserMobile
                mShipAddressTv.text = it.shipAddress!!.shipAddress
            }
        }
    }

    override fun onGetOrderByIdResult(result: Order) {
        mCurrentOrder = result
        mAdapter.setData(result.orderGoodsList)
        mTotalPriceTv.text = "合计：${YuanFenConverter.changeF2YWithUnit(result.totalPrice)}"
        updateAddressView()
    }

    override fun injectComponent() {
        DaggerOrderComponent.builder().activityComponent(activityComponent).orderModule(OrderModule()).build().inject(this)
        mPresenter.mView = this
    }

    /**
     * 取消事件监听
     */
    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }

    override fun onSubmitOrderResult(result: Boolean) {
        toast("订单提交成功")
    }
}