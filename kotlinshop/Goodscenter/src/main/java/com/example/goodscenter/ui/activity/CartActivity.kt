package com.example.goodscenter.ui.activity

import android.os.Bundle
import com.example.chen.baselibrary.ui.activity.BaseActivity
import com.example.goodscenter.R
import com.example.goodscenter.ui.fragment.CartFragment

/*
    购物车Activity
    只是Fragment一个壳
 */
class CartActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_cart)
        (fragment as CartFragment).setBackVisible(true)
    }
}
