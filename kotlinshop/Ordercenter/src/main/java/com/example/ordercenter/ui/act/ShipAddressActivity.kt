package com.example.ordercenter.ui.act

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.bigkoo.alertview.AlertView
import com.bigkoo.alertview.OnItemClickListener
import com.eightbitlab.rxbus.Bus
import com.example.chen.baselibrary.ext.Onclick
import com.example.chen.baselibrary.ext.startLoading
import com.example.chen.baselibrary.ui.activity.BaseActivity
import com.example.chen.baselibrary.ui.activity.BaseMvpActivity
import com.example.chen.baselibrary.ui.adapter.BaseRecyclerViewAdapter
import com.example.ordercenter.R
import com.example.ordercenter.injection.component.DaggerShipAddressComponent
import com.example.ordercenter.injection.module.ShipAddressModule
import com.example.ordercenter.presenter.ShipAddressPresenter
import com.example.ordercenter.presenter.view.ShipAddressView
import com.example.ordercenter.ui.adapter.ShipAddressAdapter
import com.kennyc.view.MultiStateView
import com.kotlin.order.common.OrderConstant
import com.kotlin.order.data.protocol.ShipAddress
import com.kotlin.order.event.SelectAddressEvent
import kotlinx.android.synthetic.main.activity_address.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 *   收货人信息列表页
 */
class ShipAddressActivity : BaseMvpActivity<ShipAddressPresenter>(), ShipAddressView {


    private lateinit var mAdapter: ShipAddressAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
        initView()
    }

    override fun onStart() {
        super.onStart()
        loadData()
    }

    /*
      加载数据
   */
    private fun loadData() {
        mMultiStateView.startLoading()
        mPresenter.getShipAddressList()
    }

    private fun initView() {
        mAddressRv.layoutManager = LinearLayoutManager(this)
        mAdapter = ShipAddressAdapter(this)
        mAddressRv.adapter = mAdapter
        //设置操作事件
        mAdapter.mOptClickListener = object : ShipAddressAdapter.OnOptClickListener {
            override fun onSetDefault(address: ShipAddress) {
                mPresenter.setDefaultShipAddress(address)
            }

            override fun onEdit(address: ShipAddress) {
                startActivity<ShipAddressEditActivity>(OrderConstant.KEY_SHIP_ADDRESS to address)
            }

            override fun onDelete(address: ShipAddress) {
                AlertView("删除", "确定删除该地址？", "取消", null, arrayOf("确定"),
                        this@ShipAddressActivity, AlertView.Style.Alert,
                        OnItemClickListener { o, position ->
                            if (position == 0) {
                                mPresenter.deleteShipAddress(address.id)
                            }
                        }

                ).show()
            }

        }
        //单项点击事件
        mAdapter.setOnItemClickListener(object : BaseRecyclerViewAdapter.OnItemClickListener<ShipAddress>{
            override fun onItemClick(item: ShipAddress, position: Int) {
                Bus.send(SelectAddressEvent(item))
                finish()
            }
        })
        mAddAddressBtn.Onclick {
            startActivity<ShipAddressEditActivity>()
        }
    }

    /*
        Dagger注册
     */
    override fun injectComponent() {
        DaggerShipAddressComponent.builder().activityComponent(activityComponent).shipAddressModule(ShipAddressModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onGetShipAddressResult(result: MutableList<ShipAddress>?) {
        if (result != null && result.size > 0) {
            mAdapter.setData(result)
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_CONTENT
        } else {
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_EMPTY
        }
    }

    override fun onSetDefaultResult(result: Boolean) {
        toast("设置默认成功")
        loadData()
    }

    override fun onDeleteResult(result: Boolean) {
        toast("删除成功")
        loadData()
    }
}