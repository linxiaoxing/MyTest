package com.example.hmplayer.ui.activity

import android.preference.PreferenceManager
import androidx.appcompat.widget.Toolbar
import com.example.hmplayer.R
import com.example.hmplayer.base.BaseActivity
import com.example.hmplayer.util.ToolbarManager
import org.jetbrains.anko.find

class SettingActivity : BaseActivity(), ToolbarManager {

    override val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }


    override fun getLayoutId(): Int {
        return R.layout.setting
    }


    override fun initData() {
        initSettingToolbar()
        val sp = PreferenceManager.getDefaultSharedPreferences(this)
        val push = sp.getBoolean("push", false)
        println(push)
    }
}