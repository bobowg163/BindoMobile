package com.example.bindomobile.data.datasource.remote.dtos

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午1:53
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 53
 */

@Root(name = "response", strict = false)
data class ResponseObject(
    @field:Element(name = "code",required = false)
    var code: Int = -1,
    @field:Element(name = "value",required = false)
    var value: String ="",
    @field:Element(name = "description",required = false)
    var description: String = "",
    @field:Element(name = "personInfo",required = false)
    var personInfo: PersonneInfo? = null,
    @field:ElementList(name = "comptes", entry = "compte", required = false)
    var comptes:List<Compte>? = null,
)
