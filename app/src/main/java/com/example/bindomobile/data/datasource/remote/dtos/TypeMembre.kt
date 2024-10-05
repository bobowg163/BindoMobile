package com.example.bindomobile.data.datasource.remote.dtos

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午2:09
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 09
 */

@Root(name = "typeMembre", strict = false)
data class TypeMembre(
    @field:Element(name = "code", required = false)
    var code: String = "",

    @field:Element(name = "libelle", required = false)
    var libelle: String = ""
)