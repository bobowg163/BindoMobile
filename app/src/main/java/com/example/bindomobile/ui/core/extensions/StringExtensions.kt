package com.example.bindomobile.ui.core.extensions

import java.util.Locale

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/17
 * @time 下午8:55
 * @month_full 十月
 * @day 17
 * @day_full 星期四
 * @minute 55
 */

fun String.splitStringWithDivider(
    grounpCharCount: Int = 4,
    divider: Char = ' '
): String {
    val formattedStringBuilder = StringBuilder()
    var count = 0

    for (char in this) {
        if (count > 0 && count % grounpCharCount == 0) {
            formattedStringBuilder.append(divider)
        }
        formattedStringBuilder.append(char)
        count++
    }
    return formattedStringBuilder.toString()
}

fun Float.floatToString(): String {
    return if (this == this.toInt().toFloat()) {
        String.format(Locale.getDefault(), "%d", this.toInt())
    } else {
        this.toString()
    }
}

fun String.maskCardId(visibleCharacters: Int = 4):String{
    return "*" + substring(length - visibleCharacters)
}