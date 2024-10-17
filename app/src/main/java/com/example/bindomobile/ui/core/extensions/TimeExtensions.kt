package com.example.bindomobile.ui.core.extensions

import java.text.SimpleDateFormat
import java.util.Locale

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/17
 * @time 下午9:06
 * @month_full 十月
 * @day 17
 * @day_full 星期四
 * @minute 06
 */

fun Long.getFormattedDate(format: String): String {
    val formatter = SimpleDateFormat(format, Locale.getDefault())
    return formatter.format(this)
}

fun String.getFormattedDate(format: String): String {
    val formatter = SimpleDateFormat(format, Locale.getDefault())
    return formatter.format(this)
}

fun String.convertDateToMillis(): Long {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
    val date = dateFormat.parse(this)
    return date?.time ?: 0L
}