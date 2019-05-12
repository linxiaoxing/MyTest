package com.example.ordercenter.ui.fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.launcher.ARouter
import com.bigkoo.alertview.AlertView
import com.bigkoo.alertview.OnItemClickListener
import com.example.chen.baselibrary.ext.startLoading
import com.example.chen.baselibrary.ui.adapter.BaseRecyclerViewAdapter
import com.example.chen.baselibrary.ui.fragment.BaseFragment
import com.example.chen.baselibrary.ui.fragment.BaseMvpFragment
import com.example.chen.provider.router.RouterPath
import com.example.ordercenter.R
import com.example.ordercenter.presenter.OrderListPresenter
import com.example.ordercenter.presenter.view.OrderListView
import com.example.ordercenter.ui.act.OrderDetailActivity
import com.example.ordercenter.ui.adapter.OrderAdapter
import com.kennyc.view.MultiStateView
import com.kotlin.order.common.OrderConstant
import com.kotlin.order.data.protocol.Order
import com.kotlin.order.injection.component.DaggerOrderComponent
import com.kotlin.order.injection.module.OrderModule
import com.kotlin.provider.common.ProviderConstant
import kotlinx.android.synthetic.main.fragment_order.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

/*
    订单列表Fragment
 */
class OrderFragment:BaseMvpFragment<OrderListPresenter>(),OrderListView {
    private lateinit var mAdapter: OrderAdapter

    /*
      Dagger注册
   */
    override fun injectComponent() {
        DaggerOrderComponent.builder().activityComponent(mActivityComponent).
                orderModule(OrderModule()).build().inject(this)
        mPresenter.mView = this
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_order,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    override fun onStart() {
        super.onStart()
        loadData()
    }
    private fun loadData() {
        mMultiStateView.startLoading()
        mPresenter.getOrderList(arguments!!.getInt(OrderConstant.KEY_ORDER_STATUS,-1))
    }
    /**
     *  初始化视图
     */
    private fun initView() {
        mOrderRv.layoutManager = LinearLayoutManager(activity)
        mAdapter = OrderAdapter(activity!!)
        mOrderRv.adapter = mAdapter
        /*
           列表单项点击事件
        */
        mAdapter.setOnItemClickListener(object : BaseRecyclerViewAdapter.OnItemClickListener<Order> {
            override fun onItemClick(item: Order, position: Int) {
                startActivity<OrderDetailActivity>(ProviderConstant.KEY_ORDER_ID to item.id)
            }
        })
        /*
           订单对应操作
        */
        mAdapter.listener = object :OrderAdapter.OnOptClickListener {
            override fun onOptClick(optType: Int, order: Order) {
                when(optType){
                    OrderConstant.OPT_ORDER_PAY -> {
                        ARouter.getInstance().build(RouterPath.PaySDK.PATH_PAY)
                                .withInt(ProviderConstant.KEY_ORDER_ID,order.id)
                                .withLong(ProviderConstant.KEY_ORDER_PRICE,order.totalPrice)
                                .navigation()
                    }
                    OrderConstant.OPT_ORDER_CONFIRM -> {
                        mPresenter.confirmOrder(order.id)
                    }
                    OrderConstant.OPT_ORDER_CANCEL -> {
                        showCancelDialog(order)
                    }
                }
            }
        }
    }
    /*
         取消订单对话框
      */
    private fun showCancelDialog(order:Order) {
        AlertView("取消订单", "确定取消该订单？", "取消", null, arrayOf("确定"), activity, AlertView.Style.Alert, OnItemClickListener { o, position ->
            if (position == 0){
                mPresenter.cancelOrder(order.id)
            }
        }

        ).show()
    }
    /*
       获取订单列表回调
    */
    override fun onGetOrderListResult(result: MutableList<Order>?) {
        if (result != null && result.size > 0){
            mAdapter.setData(result)
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_CONTENT
        }else{
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_EMPTY
        }
    }

    /*
         订单确认收货回调
      */
    override fun onConfirmOrderResult(result: Boolean) {
        toast("确认收货成功")
        loadData()
    }

    /*
        取消订单回调
     */
    override fun onCancelOrderResult(result: Boolean) {
        toast("取消订单成功")
        loadData()
    }


}
