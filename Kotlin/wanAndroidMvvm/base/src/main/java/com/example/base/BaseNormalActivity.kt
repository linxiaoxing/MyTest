package com.example.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import kotlinx.android.synthetic.main.title_layout.*

abstract class BaseNormalActivity : AppCompatActivity() {

    private var mDialog: MaterialDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        initView()
        setSupportActionBar(mToolbar)
        initData()
    }

    abstract fun getLayoutResId(): Int
    abstract fun initView()
    abstract fun initData()

    protected fun startActivity(z: Class<*>) {
        startActivity(Intent(this, z))
    }

    protected fun startActivity(z: Class<*>, name: String, value : Boolean) {
        val intent = Intent(this, z).putExtra(name, value)
        startActivity(intent)
    }

    protected fun showProgressDialog(content: String) {
        if (mDialog == null)
            mDialog = MaterialDialog.Builder(this)
                .content(content).progress(true, 1)
                .canceledOnTouchOutside(false).build()
        else
            mDialog?.setContent(content)
        mDialog?.show()
    }

    protected fun showProgressDialog(resId: Int) {
        if (mDialog == null)
            mDialog = MaterialDialog.Builder(this)
                .content(getString(resId)).progress(true, 1)
                .canceledOnTouchOutside(false).build()
        else
            mDialog?.setContent(getString(resId))
        mDialog?.show()
    }

    protected fun dismissProgressDialog() {
        mDialog?.dismiss()
    }
}