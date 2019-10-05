package com.example.hmplayer.ui.activity

import androidx.appcompat.widget.Toolbar
import com.example.hmplayer.R
import com.example.hmplayer.base.BaseActivity
import com.example.hmplayer.util.FragmentUtil
import com.example.hmplayer.util.ToolbarManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find

class MainActivity : BaseActivity(), ToolbarManager {

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun getLayoutId(): Int {
       return R.layout.activity_main
    }

    override fun initData() {
        initMainToolbar()
    }

    override fun initListener() {
        bottomBar.setOnTabSelectListener {
            val transaction = supportFragmentManager.beginTransaction()
            FragmentUtil.fragmentUtil.getFragment(it)?.let { current ->
                transaction.replace(R.id.container,
                    current, it.toString())
                transaction.commit()
            }
        }
    }
}
