package com.example.bindomobile.data.datasource.remote.dtos

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/10
 * @time 下午10:02
 * @month_full 十月
 * @day 10
 * @day_full 星期四
 * @minute 02
 */
@Root(name = "statement", strict = false)
data class Statement(

    @field:Element(name = "reference", required = false)
    var reference: String = "",

    @field:Element(name = "label", required = false)
    var label: String = "",

    @field:Element(name = "amount", required = false)
    var amount: Int = 0,

    @field:Element(name = "operationDate", required = false)
    var operationDate: String = "", //Date système

    @field:Element(name = "valueDate", required = false)
    var valueDate: String = "", //Date journée comptable

    @field:Element(name = "valueDateText", required = false)
    var valueDateText: String = "" //Date journée comptable texte
)