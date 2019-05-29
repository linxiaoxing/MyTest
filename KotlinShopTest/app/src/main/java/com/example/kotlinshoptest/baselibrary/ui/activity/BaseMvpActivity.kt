package com.example.baselibrary.ui.activity

import android.os.Bundle
import android.support.v7.view.menu.BaseMenuPresenter
import com.alibaba.android.arouter.launcher.ARouter
import com.example.baselibrary.common.BaseApplication
import com.example.baselibrary.common.ProgressLoading
import com.example.baselibrary.injection.component.ActivityComponent
import com.example.baselibrary.injection.component.DaggerActivityComponent
import com.example.baselibrary.injection.module.ActivityModule
import com.example.baselibrary.injection.module.LifeCycleProviderModule
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.presenter.view.BaseView
import org.jetbrains.anko.toast
import javax.inject.Inject


open abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {


    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    override fun error(text:String) {
        toast(text)
    }

    @Inject
    lateinit var mPresenter: T;
    lateinit var activityComponent: ActivityComponent

    private lateinit var mLoadingDialog:ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initInjection()
        injectComponent()
        mLoadingDialog = ProgressLoading.create(this)
        //ARouter注册
        ARouter.getInstance().inject(this)
    }

    abstract fun injectComponent()
    private fun initInjection() {
        activityComponent = DaggerActivityComponent.builder().appComponent((application
                as BaseApplication).appComponent).activityModule(ActivityModule(this))
            .lifeCycleProviderModule(LifeCycleProviderModule(this))
            .build()

    }}