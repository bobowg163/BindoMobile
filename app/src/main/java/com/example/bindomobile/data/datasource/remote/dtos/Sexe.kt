package com.example.bindomobile.data.datasource.remote.dtos

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/10
 * @time 下午10:00
 * @month_full 十月
 * @day 10
 * @day_full 星期四
 * @minute 00
 */
@Root(name = "Sexe", strict = false)
data class Sexe(
    @field:Element(name = "code", required = false)
    var code : String,
    @field:Element(name = "libelle", required = false)
    var libelle : String
)