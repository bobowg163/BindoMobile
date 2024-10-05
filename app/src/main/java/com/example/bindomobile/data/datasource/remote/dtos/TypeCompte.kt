package com.example.bindomobile.data.datasource.remote.dtos

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午2:08
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 08
 */
@Root(name = "typeCompte", strict = false)
data class TypeCompte(
    @field:Element(name = "code", required = false)
    var code: String = "",

    @field:Element(name = "libelle", required = false)
    var libelle: String = ""
)