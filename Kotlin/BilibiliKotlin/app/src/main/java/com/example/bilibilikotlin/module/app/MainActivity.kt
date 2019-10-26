package com.example.bilibilikotlin.module.app

import android.annotation.SuppressLint
import android.view.KeyEvent
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.bilibilikotlin.App
import com.example.bilibilikotlin.R
import com.example.bilibilikotlin.base.BaseActivity
import com.example.bilibilikotlin.event.Event
import com.example.bilibilikotlin.module.home.HomeFragment
import com.example.bilibilikotlin.rx.RxBus
import com.example.bilibilikotlin.utils.AppUtils
import com.example.bilibilikotlin.widget.StatusBarUtil
import com.google.android.material.internal.NavigationMenuView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var exitTime = 0L
    private var mCurrentPos = -1
    private var mFragments = mutableListOf<Fragment>()

    override fun getLayoutId(): Int = R.layout.activity_main

    private fun initFragment() {
        mFragments.add(HomeFragment.newInstance())

    }

    override fun initWidget() {
        disableNavigationViewScrollbars(navView)
        navView.setNavigationItemSelectedListener(this)
        switchFragmentIndex(0)//初始化位置
    }

    @SuppressLint("CommitTransaction")
    fun switchFragmentIndex(index: Int) {
        if (mFragments.size == 0) {
            return
        }
        supportFragmentManager
            .beginTransaction()
            .apply {
                if (mCurrentPos != -1)
                    hide(mFragments[mCurrentPos])
                if (!mFragments[index].isAdded) {
                    add(R.id.flContent, mFragments[index])
                }
                show(mFragments[index]).commit()
            }
    }

    override fun initStatusBar() {
        StatusBarUtil.setColorNoTranslucentForDrawerLayout(this, mDrawerLayout, AppUtils.getColor(R.color.colorPrimary))
    }

    override fun initVariables() {
        initFragment()
        //监听事件
        RxBus.toFlowable(Event.StartNavigationEvent::class.java)
            .compose(bindToLifecycle())
            .subscribe({
                if (it.start) {
                    toggleDrawer()//打开
                }
            })
    }

    /**
     * DrawerLayout侧滑菜单开关
     */
    fun toggleDrawer() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            mDrawerLayout.openDrawer(GravityCompat.START)
        }
    }

    /**
     * 去掉滚动条
     * @param navigationView navigationView
     */
    private fun disableNavigationViewScrollbars(navigationView: NavigationView?) {
        navigationView?.let {
            val navigationMenuView = it.getChildAt(0) as NavigationMenuView
            navigationMenuView.isVerticalFadingEdgeEnabled = false
        }
    }

    /**
     * 侧滑面板监听事件
     * @param item
     * *
     * @return
     */
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        AppUtils.runOnUIDelayed({
//            when (item.itemId) {
//                R.id.item_vip -> startActivity(Intent(this@MainActivity, VipActivity::class.java))
//                R.id.item_unicom -> BrowerActivity.startActivity(this@MainActivity, Constants.BLACK_BOARD_URL, "联通免流量服务", "")
//                R.id.item_down -> startActivity(Intent(this@MainActivity, OfflineDownloadActivity::class.java))
//            }
        }, 230)
        mDrawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


    /**
     * 监听back键处理
     */
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mDrawerLayout.isDrawerOpen(mDrawerLayout.getChildAt(1))) {
                mDrawerLayout.closeDrawers()
            } else {
                exitApp()
            }
        }
        return true
    }

    /**
     * 双击退出App
     */
    private fun exitApp() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            toast("再按一次退出")
            exitTime = System.currentTimeMillis()
        } else {
            App.instance.exitApp()
        }
    }

}
