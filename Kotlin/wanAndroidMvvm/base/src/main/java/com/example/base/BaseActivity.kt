package com.example.base

import android.content.Intent
import android.os.Bundle
import com.afollestad.materialdialogs.MaterialDialog
import androidx.lifecycle.ViewModelProviders
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.title_layout.*

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    private var mDialog: MaterialDialog? = null
    protected lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        initVM()
        initView()
        setSupportActionBar(mToolbar)
        initData()
        startObserve()
    }

    open fun startObserve() {
    }

    abstract fun getLayoutResId(): Int
    abstract fun initView()
    abstract fun initData()

    private fun initVM() {
        providerVMClass()?.let {
            mViewModel = ViewModelProviders.of(this).get(it)
            mViewModel.let { lifecycle::addObserver }
        }
    }

    open fun providerVMClass(): Class<VM>? = null

    protected fun startActivity(z: Class<*>) {
        startActivity(Intent(this, z))
    }

    protected fun showProgressDialog(content: String) {
        if (mDialog == null) {
            mDialog = MaterialDialog.Builder(this)
                .content(content).progress(true, 1)
                .canceledOnTouchOutside(false).build()
        } else {
            mDialog?.setContent(content)
        }
        mDialog?.show()
    }

    protected fun showProgressDialog(resId: Int) {
        if (mDialog == null) {
            mDialog = MaterialDialog.Builder(this)
                .content(getString(resId)).progress(true, 1)
                .canceledOnTouchOutside(false).build()
        } else {
            mDialog?.setContent(getString(resId))
        }
    }

    protected fun dismissProgressDialog() {
        if (mDialog == null) {
            mDialog?.dismiss()
        }
    }

    override fun onDestroy() {
        mViewModel.let {
            lifecycle.removeObserver(it)
        }
        super.onDestroy()
    }
}