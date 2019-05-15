package com.example.baselibrary.ui.fragment

import android.os.Bundle
import com.example.baselibrary.common.BaseApplication
import com.example.baselibrary.injection.component.ActivityComponent
import com.example.baselibrary.injection.component.DaggerActivityComponent
import com.example.baselibrary.injection.module.ActivityModule
import com.example.baselibrary.injection.module.LifeCycleProviderModule
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.presenter.view.BaseView
import org.jetbrains.anko.toast
import javax.inject.Inject

open  abstract class BaseMvpFragment<T: BasePresenter<*>> : BaseFragment(), BaseView {

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun error(text:String) {
        mActivityComponent.activity().toast(text)
    }

    @Inject
    lateinit var mPresenter: T
    lateinit var mActivityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initInjection()
        injectComponent()
    }

    abstract fun injectComponent()
    private fun initInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
            .appComponent((activity!!.application as BaseApplication).appComponent)
            .activityModule(ActivityModule((activity!!)))
            .lifeCycleProviderModule(LifeCycleProviderModule(this))
            .build()
    }

}