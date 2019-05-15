package com.example.kotlinshoptest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.baselibrary.ui.fragment.BaseFragment
import com.example.kotlinshoptest.R
import com.example.kotlinshoptest.baselibrary.ext.OnClick
import com.example.kotlinshoptest.ui.activity.SettingActivity
import kotlinx.android.synthetic.main.fragment_me.*
import org.jetbrains.anko.support.v4.startActivity

class MeFragment : BaseFragment(), View.OnClickListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_me, null)

    }

    override fun onStart() {
        super.onStart()
        //loadData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    /*
        初始化视图
     */
    private fun initView() {
        mUserIconIv.OnClick(this)
        mUserNameTv.OnClick(this)
        mSettingTv.OnClick(this)
        mAddressTv.OnClick(this)
        mWaitPayOrderTv.OnClick(this)
        mWaitConfirmOrderTv.OnClick(this)
        mCompleteOrderTv.OnClick(this)
        mAllOrderTv.OnClick(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
//            R.id.mUserIconIv, R.id.mUserNameTv -> {
//                if(isLogined()){
//                    startActivity<UserInfoActivity>()
//                }else{
//                    startActivity<LoginActivity>()
//                }
//
//            }
            R.id.mSettingTv->{
                startActivity<SettingActivity>()
            }
//            R.id.mAddressTv -> {
//                afterLogin {
//                    startActivity<ShipAddressActivity>()
//                }
//            }
//            R.id.mWaitPayOrderTv -> {
//                startActivity<OrderActivity>(OrderConstant.KEY_ORDER_STATUS to OrderStatus.ORDER_WAIT_PAY)
//            }
//            R.id.mWaitConfirmOrderTv -> {
//                startActivity<OrderActivity>(OrderConstant.KEY_ORDER_STATUS to OrderStatus.ORDER_WAIT_CONFIRM)
//            }
//            R.id.mCompleteOrderTv -> {
//                startActivity<OrderActivity>(OrderConstant.KEY_ORDER_STATUS to OrderStatus.ORDER_COMPLETED)
//            }
//            R.id.mAllOrderTv -> {
//                afterLogin {
//                    startActivity<OrderActivity>()
//                }
//            }
//
        }
    }


}