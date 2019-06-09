package com.example.baselibrary.utils

import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

/**
 * 日期工具类 默认使用 "yyyy-MM-dd HH:mm:ss" 格式化日期
 */
object DateUtils {

    /**
     * 英文简写（默认）如：12-01
     */
    val FORMAT_MONTH_DAY = "MM-dd"
    /**
     * 英文简写（默认）如：2010-12-01
     */
    val FORMAT_SHORT = "yyyy-MM-dd"
    /**
     * 英文全称 如：2010-12-01 23:15:06
     */
    /**
     * 获得默认的 date pattern
     */
    val datePattern = "yyyy-MM-dd HH:mm:ss"

    val FORMAT_LONG_NEW = "yyyy-MM-dd HH:mm"
    /**
     * 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.S
     */
    val FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S"
    /**
     * 中文简写 如：2010年12月01日
     */
    val FORMAT_SHORT_CN_MINI = "MM月dd日 HH:mm"
    /**
     * 中文简写 如：2010年12月01日
     */
    val FORMAT_SHORT_CN = "yyyy年MM月dd日"
    /**
     * 中文全称 如：2010年12月01日 23时15分06秒
     */
    val FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒"
    /**
     * 精确到毫秒的完整中文时间
     */
    val FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒"
    /**
     * 精确到毫秒的完整中文时间
     */
    val FORMAT_SPEFULL_CN = "yyyy年MM月dd日  HH:mm"
    /**
     * 英文简写（默认）如：2010-12-01
     */
    val FORMAT_SHORT_SPE = "yyyyMMdd"
    val FORMAT_SHORT_SPE_ = "HH:mm"

    val TIMEZONE = "Asia/Shanghai"

    /**
     * 根据预设格式返回当前日期
     * @return
     */
    val now: String
       get() = format(Date())

    val defTimeZone: TimeZone
       get() = TimeZone.getTimeZone(TIMEZONE)

    /**
     * 使用用户格式格式化日期
     * @param date
     * *            日期
     * *
     * @param pattern
     * *            日期格式
     * *
     * @return
     */
    @JvmOverloads fun format(date: Date?, pattern: String = datePattern): String {
        var returnValue = ""
        if (date != null) {
            val df = SimpleDateFormat(pattern)
            df.timeZone = defTimeZone
            returnValue = df.format(date)
        }
        return returnValue
    }
}