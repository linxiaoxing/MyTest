package com.example.chen.kotlinshop.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chen.baselibrary.ext.Onclick
import com.example.chen.baselibrary.ext.loadUrl
import com.example.chen.baselibrary.ui.fragment.BaseFragment
import com.example.chen.baselibrary.utils.AppPrefsUtils
import com.example.chen.kotlinshop.R
import com.example.chen.kotlinshop.ui.activity.SettingActivity
import com.example.chen.provider.common.afterLogin
import com.example.chen.provider.common.isLogined
import com.example.chen.usercenter.ui.activity.LoginActivity
import com.example.chen.usercenter.ui.activity.UserInfoActivity
import com.example.ordercenter.ui.act.OrderActivity
import com.example.ordercenter.ui.act.ShipAddressActivity
import com.kotlin.order.common.OrderConstant
import com.kotlin.order.common.OrderStatus
import com.kotlin.provider.common.ProviderConstant
import kotlinx.android.synthetic.main.fragment_me.*
import org.jetbrains.anko.support.v4.startActivity

class MeFragment : BaseFragment(), View.OnClickListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_me, null)

    }

    override fun onStart() {
        super.onStart()
        loadData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    /*
        初始化视图
     */
    private fun initView() {
        mUserIconIv.Onclick(this)
        mUserNameTv.Onclick(this)
        mSettingTv.Onclick(this)
        mAddressTv.Onclick(this)
        mWaitPayOrderTv.Onclick(this)
        mWaitConfirmOrderTv.Onclick(this)
        mCompleteOrderTv.Onclick(this)
        mAllOrderTv.Onclick(this)
    }

    /**
     * 加载初始数据
     */
    private fun loadData() {
        if (isLogined()) {
            val userIcon = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_ICON)
            if (userIcon.isNotEmpty()) {
                mUserIconIv.loadUrl(userIcon)
            }
            mUserNameTv.text = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_NAME)
        } else {
            mUserIconIv.setImageResource(R.drawable.icon_default_user)
            mUserNameTv.text = getString(R.string.un_login_text)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.mUserIconIv, R.id.mUserNameTv -> {
                if(isLogined()){
                    startActivity<UserInfoActivity>()
                }else{
                    startActivity<LoginActivity>()
                }

            }
            R.id.mSettingTv->{
                startActivity<SettingActivity>()
            }
            R.id.mAddressTv -> {
                afterLogin {
                    startActivity<ShipAddressActivity>()
                }
            }
            R.id.mWaitPayOrderTv -> {
                startActivity<OrderActivity>(OrderConstant.KEY_ORDER_STATUS to OrderStatus.ORDER_WAIT_PAY)
            }
            R.id.mWaitConfirmOrderTv -> {
                startActivity<OrderActivity>(OrderConstant.KEY_ORDER_STATUS to OrderStatus.ORDER_WAIT_CONFIRM)
            }
            R.id.mCompleteOrderTv -> {
                startActivity<OrderActivity>(OrderConstant.KEY_ORDER_STATUS to OrderStatus.ORDER_COMPLETED)
            }
            R.id.mAllOrderTv -> {
                afterLogin {
                    startActivity<OrderActivity>()
                }
            }

        }
    }

}