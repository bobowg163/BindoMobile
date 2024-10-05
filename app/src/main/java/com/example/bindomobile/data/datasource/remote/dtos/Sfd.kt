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
@Root(name = "sfd", strict = false)
data class Sfd(

    @field:Element(name = "code", required = false)
    var code: String = "",

    @field:Element(name = "libelle", required = false)
    var libelle: String = "",

    @field:Element(name = "logo", required = false)
    var logo: String = "",

    @field:Element(name = "pays", required = false)
    var pays: Pays? = null,

    @field:Element(name = "prefixCompte", required = false)
    var prefixCompte: String = "",
)