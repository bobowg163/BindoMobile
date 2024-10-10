package com.example.bindomobile.data.datasource.remote.dtos

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/10
 * @time 下午9:46
 * @month_full 十月
 * @day 10
 * @day_full 星期四
 * @minute 46
 */
@Root(name = "member", strict = false)
data class MFIMember(
    @field:Element(name = "lastName", required = false)
    var lastName: String = "",

    @field:Element(name = "firstName", required = false)
    var firstName: String = "",

    @field:Element(name = "accountType", required = false)
    var accountType: String = "",

    @field:Element(name = "balance", required = false)
    var balance: Int = 0,

    @field:Element(name = "phone", required = false)
    var phone: String = "",

    @field:Element(name = "currencyCode", required = false)
    var currencyCode: String = "",

    @field:Element(name = "birthDateText", required = false)
    var birthDateText: String = "",

    @field:Element(name = "gender", required = false)
    var gender: String = "",

    @field:Element(name = "address", required = false)
    var address: String = "",

    @field:Element(name = "phoneCode", required = false)
    var phoneCode: String = "",
) {
    val fullName
        get() = "$firstName $lastName"
}