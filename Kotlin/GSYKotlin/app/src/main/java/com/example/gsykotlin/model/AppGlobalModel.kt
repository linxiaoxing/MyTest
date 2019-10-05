package com.example.gsykotlin.model

import com.example.gsykotlin.model.ui.UserUIModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 * app全局数据对象

 */
@Singleton
class AppGlobalModel @Inject constructor() {
    val userObservable = UserUIModel()
}