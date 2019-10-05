package com.example.hmplayer.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast
import org.jetbrains.anko.startActivity

/**
 * Activity基类
 */
abstract class BaseActivity: AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initListener()
        initData()
    }

    /**
     * 获取布局id
     */
    abstract fun getLayoutId(): Int


    /**
     * 设置一些Listener
     */
    protected open fun initListener() {

    }

    /**
     * 初始化数据
     */
    protected open fun initData() {

    }

    /**
     * 考虑线程的Toast方法
     */
    fun myToast(msg: String) {
        runOnUiThread { toast(msg) }
    }

    /**
     * 开启Activity并关闭当前界面
     */
    inline fun <reified T : BaseActivity> startActivityAndFinish() {
        startActivity<T>()
        finish()
    }

}