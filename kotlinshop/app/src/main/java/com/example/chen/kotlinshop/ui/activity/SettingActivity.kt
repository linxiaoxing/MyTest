package com.example.chen.kotlinshop.ui.activity

import android.os.Bundle
import com.example.chen.baselibrary.ext.Onclick
import com.example.chen.baselibrary.ui.activity.BaseActivity
import com.example.chen.kotlinshop.R
import com.kotlin.user.utils.UserPrefsUtils
import kotlinx.android.synthetic.main.activity_setting.*

/*
    设置界面
 */
class SettingActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        //退出登录，清空本地用户数据
        mLogoutBtn.Onclick {
            UserPrefsUtils.putUserInfo(null)
            finish()
        }
    }
}
