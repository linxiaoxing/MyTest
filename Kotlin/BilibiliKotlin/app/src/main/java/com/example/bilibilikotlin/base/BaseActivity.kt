package com.example.bilibilikotlin.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import com.example.bilibilikotlin.App
import com.example.bilibilikotlin.R
import com.example.bilibilikotlin.utils.AppUtils
import com.example.bilibilikotlin.widget.StatusBarUtil
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
/**
 * 基础Activity
 */
abstract class BaseActivity : RxAppCompatActivity() {

    protected var mToolbar: Toolbar? = null//Toolbar
    protected var mContext: Context? = null//上下文环境
    protected open val mBack = true //是否返回
    protected var mError: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        mContext = this
        mToolbar = findViewById(R.id.toolbar) as? Toolbar
        mError = findViewById(R.id.cl_error) as? LinearLayout
        initStatusBar()
        initInject()
        initPresenter()
        initVariables()
        App.instance.addActivity(this)

        mToolbar?.let {
            //初始化Toolbar
            initToolbar()
            //让组件支持Toolbar
            setSupportActionBar(it)
            // supportActionBar
            if (mBack) it.setNavigationOnClickListener { finish() }
        }
        initWidget()
        initDatas()
    }

    /**
     * 布局文件
     * @return 布局文件
     */

    abstract fun getLayoutId(): Int

    /**
     * 注入依赖
     */
    open fun initInject() {

    }

    /**
     * 完成请求
     */
    open fun finishTask() {}

    /**
     * 初始化StatusBar
     */
    open fun initStatusBar() {
        StatusBarUtil.setColorNoTranslucent(mContext as Activity, AppUtils.getColor(R.color.colorPrimary))
    }

    /**
     * 初始化Presenter
     */
    open fun initPresenter() {
        //  mPresenter?.attachView(this)
    }

    /**
     * 初始化变量
     */
    open fun initVariables() {}

    /**
     * 初始化Toolbar
     */
    open fun initToolbar() {
        if (mBack) mToolbar?.setNavigationIcon(R.drawable.ic_clip_back_white)
    }

    /**
     * 初始化控件
     */
    open fun initWidget() {}

    /**
     * 加载数据
     */
    open fun loadData() {}

    /**
     * 初始化数据
     */
    open fun initDatas() {
        loadData()
    }

    /**
     * 隐藏View
     * @param views 视图
     */
    fun gone(vararg views: View) {
        if (views.isNotEmpty()) {
            for (view in views) {
                view.visibility = View.GONE
            }
        }
    }

    /**
     * 显示View
     * @param views 视图
     */
    fun visible(vararg views: View) {
        if (views.isNotEmpty()) {
            for (view in views) {
                view.visibility = View.VISIBLE
            }
        }
    }

}