package com.example.kotlinshoptest.ui.activity

import android.os.Bundle
import android.view.View
import com.example.baselibrary.ui.activity.BaseActivity
import com.example.kotlinshoptest.R
import com.example.kotlinshoptest.baselibrary.ext.OnClick
import com.example.kotlinshoptest.usercenter.utils.UserPrefsUtils
import kotlinx.android.synthetic.main.activity_setting.*

/*
    设置界面
 */
class SettingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        //退出登录，清空本地用户数据
        mLogoutBtn.OnClick (object : View.OnClickListener {
            override fun onClick(v: View?) {
                UserPrefsUtils.putUserInfo(null)
                finish()
            }
        })
    }
}