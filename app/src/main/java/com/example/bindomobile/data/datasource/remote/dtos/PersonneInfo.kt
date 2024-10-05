package com.example.bindomobile.data.datasource.remote.dtos

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午1:59
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 59
 */
@Root(name = "personneInfo", strict = false)
data class PersonneInfo(
    @field:Element(name = "changerMotDePasse", required = false)
    var changerMotDePasse: Boolean = false,

    @field:Element(name = "code", required = false)
    var code:String="",

    @field:Element(name = "nom", required = false)
    var nom:String="",

    @field:Element(name = "prenom", required = false)
    var prenom:String="",

    @field:Element(name = "telephone", required = false)
    var telephone:String="",
)
