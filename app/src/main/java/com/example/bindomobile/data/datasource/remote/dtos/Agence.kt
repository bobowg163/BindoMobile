package com.example.bindomobile.data.datasource.remote.dtos

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午2:07
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 07
 */
@Root(name = "agence", strict = false)
data class Agence(

    @field:Element(name = "code", required = false)
    var code: String = "",

    @field:Element(name = "codeSIG", required = false)
    var codeSIG: String = "",

    @field:Element(name = "email", required = false)
    var email: String = "",

    @field:Element(name = "latitude", required = false)
    var latitude: Double = 0.0,

    @field:Element(name = "libelle", required = false)
    var libelle: String = "",

    @field:Element(name = "localite", required = false)
    var localite: String = "",

    @field:Element(name = "longitude", required = false)
    var longitude: Double = 0.0,

    @field:Element(name = "sfd", required = false)
    var sfd: Sfd? = null,

    @field:Element(name = "telephone", required = false)
    var telephone: String = "",

//    @field:Element(name = "codeAgentCredit", required = false)
//    val codeAgentCredit: String,
)