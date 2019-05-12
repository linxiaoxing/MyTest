package com.example.goodscenter.ui.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.view.Gravity
import com.alibaba.android.arouter.launcher.ARouter
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.example.chen.baselibrary.ext.Onclick
import com.example.chen.baselibrary.ui.activity.BaseActivity
import com.example.chen.baselibrary.utils.AppPrefsUtils
import com.example.chen.provider.common.afterLogin
import com.example.chen.provider.router.RouterPath
import com.example.goodscenter.R
import com.example.goodscenter.common.GoodsConstant
import com.example.goodscenter.event.AddCartEvent
import com.example.goodscenter.event.UpdateCartSizeEvent
import com.example.goodscenter.ui.adapter.GoodsDetailVpAdapter
import kotlinx.android.synthetic.main.activity_goods_detail.*
import org.jetbrains.anko.startActivity
import q.rorbin.badgeview.QBadgeView

class GoodsDetailActivity : BaseActivity() {
    private lateinit var mCartBdage: QBadgeView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods_detail)
        initView()
        initObserve()
        loadCartSize()
    }

    private fun initView() {
        mGoodsDetailTab.tabMode = TabLayout.MODE_FIXED
        //TabLayout关联ViewPager
        mGoodsDetailTab.setupWithViewPager(mGoodsDetailVp)
        mGoodsDetailVp.adapter = GoodsDetailVpAdapter(supportFragmentManager, this)
        mAddCartBtn.Onclick {
            afterLogin {
                Bus.send(AddCartEvent())
            }
        }
        mEnterCartTv.Onclick {
            startActivity<CartActivity>()
        }
        mLeftIv.Onclick {
            finish()
        }
        mCartBdage = QBadgeView(this)
    }

    /*
       监听购物车数量变化
    */
    private fun initObserve() {
        Bus.observe<UpdateCartSizeEvent>()
                .subscribe {
                    setCartBadge()
                }.registerInBus(this)
    }

    /*
        设置购物车标签
     */
    private fun setCartBadge() {
        mCartBdage.badgeGravity = Gravity.END or Gravity.TOP
        mCartBdage.setGravityOffset(22f, -2f, true)
        mCartBdage.setBadgeTextSize(6f, true)
        mCartBdage.bindTarget(mEnterCartTv).badgeNumber = AppPrefsUtils.getInt(GoodsConstant.SP_CART_SIZE)

    }

    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }
    /*
           加载购物车数量
        */
    private fun loadCartSize() {
        setCartBadge()
    }
}