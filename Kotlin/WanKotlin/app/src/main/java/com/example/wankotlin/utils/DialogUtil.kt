package com.example.wankotlin.utils

import android.app.ProgressDialog
import android.content.Context
import android.text.TextUtils
import android.widget.ProgressBar


/**
 * Created by chenxz on 2018/6/9.
 * 对话框辅助类,需要自己调用show方法
 */
object DialogUtil {

    /**
     * 获取一个耗时的对话框 ProgressDialog
     *
     * @param context
     * @param message
     * @return
     */
    fun getWaitDialog(context: Context, message: String): ProgressDialog {
        val waitDialog = ProgressDialog(context)
        if (!TextUtils.isEmpty(message)) {
            waitDialog.setMessage(message)
        }
        return waitDialog
    }
}