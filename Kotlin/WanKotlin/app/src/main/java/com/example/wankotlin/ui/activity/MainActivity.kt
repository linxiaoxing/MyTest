package com.example.wankotlin.ui.activity

import android.os.Bundle
import android.widget.TextView
import com.example.wankotlin.R
import com.example.wankotlin.base.BaseMvpActivity
import com.example.wankotlin.constant.Constant
import com.example.wankotlin.mvp.contract.MainContract
import com.example.wankotlin.mvp.presenter.MainPresenter
import com.example.wankotlin.utils.Preference
import com.tencent.bugly.beta.Beta
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseMvpActivity<MainContract.View, MainContract.Presenter>(), MainContract.View {

    private val BOTTOM_INDEX: String = "bottom_index"

    private val FRAGMENT_HOME = 0x01
    private val FRAGMENT_KNOWLEDGE = 0x02
    private val FRAGMENT_NAVIGATION = 0x03
    private val FRAGMENT_PROJECT = 0x04
    private val FRAGMENT_WECHAT = 0x05

    private var mIndex = FRAGMENT_HOME

    override fun createPresenter(): MainContract.Presenter = MainPresenter()

    /**
     * local username
     */
    private val username: String by Preference(Constant.USERNAME_KEY, "")

    /**
     * username TextView
     */
    private var nav_username: TextView? = null

    override fun attachLayoutRes(): Int = R.layout.activity_main

    override fun initData() {
        Beta.checkUpgrade(false, false)
    }

    override fun useEventBus(): Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            mIndex = savedInstanceState?.getInt(BOTTOM_INDEX)
        }
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        super.initView()
        toolbar.run {
            title = getString(R.string.app_name)
            setSupportActionBar(this)
        }
    }

    override fun initColor() {
        super.initColor()
        //refreshColor(ColorEvent(true))
    }

    override fun start() {
    }

    override fun recreate() {}

    override fun showLogoutSuccess(success: Boolean) {}
}