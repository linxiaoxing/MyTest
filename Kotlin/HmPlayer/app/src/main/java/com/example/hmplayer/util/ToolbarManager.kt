package com.example.hmplayer.util

import android.content.Intent
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.hmplayer.R
import com.example.hmplayer.ui.activity.SettingActivity

/**
 * ClassName: ToolBarManager
 */
interface ToolbarManager {

    val toolbar: Toolbar

    /**
     * 初始化主界面中的toolbar
     */
    fun initMainToolbar() {
        toolbar.setTitle("黑马影音")
        toolbar.inflateMenu(R.menu.main)
//        toolbar.setOnMenuItemClickListener(object : Toolbar.OnMenuItemClickListener {
//            override fun onMenuItemClick(item: MenuItem?): Boolean {
//                when (item?.itemId) {
//                    R.id.setting -> {
//                        toolbar.context.startActivity(Intent(toolbar.context, SettingActivity::class.java))
//                        Toast.makeText(toolbar.context, "点击了设置按钮", Toast.LENGTH_SHORT).show()
//                    }
//                }
//                return true
//            }
//        })

        // 如果java接口中只有一个未实现的方法，可以省略接口对象，直接用{}表示未显示方法
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                    R.id.setting -> {
                        toolbar.context.startActivity(Intent(toolbar.context, SettingActivity::class.java))
                        Toast.makeText(toolbar.context, "点击了设置按钮", Toast.LENGTH_SHORT).show()
                    }
                }
            true
        }
    }

    /**
     * 处理设置界面的toolbar
     */
    fun initSettingToolbar() {
        toolbar.setTitle("设置界面")
    }
}