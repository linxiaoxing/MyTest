package com.example.chen.baselibrary.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.example.chen.baselibrary.common.BaseApplication
import com.example.chen.baselibrary.common.ProgressLoading
import com.example.chen.baselibrary.injection.component.ActivityComponent
import com.example.chen.baselibrary.injection.component.DaggerActivityComponent
import com.example.chen.baselibrary.injection.module.ActivityModule
import com.example.chen.baselibrary.injection.module.LifeCycleProviderModule
import com.example.chen.baselibrary.presenter.BasePresenter
import com.example.chen.baselibrary.presenter.view.BaseView
import org.jetbrains.anko.toast
import javax.inject.Inject

open  abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {
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
        mLoadingDialog= ProgressLoading.create(this)
        //ARouter注册
        ARouter.getInstance().inject(this)
    }
    abstract fun injectComponent()
    private fun initInjection() {
        activityComponent = DaggerActivityComponent.builder().
                appComponent((application as BaseApplication).appComponent).
                activityModule(ActivityModule(this))
                //RxAppCompatActivity中实现了LifecycleProvider接口,所以直接传它的对象this
                .lifeCycleProviderModule(LifeCycleProviderModule(this))
                .build()
    }

}