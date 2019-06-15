package com.example.wankotlin.event

import com.example.wankotlin.utils.SettingUtil

class ColorEvent(var isRefresh: Boolean, var color: Int = SettingUtil.getColor())