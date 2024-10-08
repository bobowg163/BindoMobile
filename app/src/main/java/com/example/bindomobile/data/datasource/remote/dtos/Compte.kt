package com.example.bindomobile.data.datasource.remote.dtos

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午2:06
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 06
 */
@Root(name = "compte", strict = false)
data class Compte(
    @field:Element(name = "abonnementActif", required = false)
    var abonnementActif: Boolean = true,

    @field:Element(name = "agence", required = false)
    var agence: Agence? = null,

    @field:Element(name = "code", required = false)
    var code: String = "",

    @field:Element(name = "codeDevise", required = false)
    var codeDevise: String = "",

    @field:Element(name = "intituleCompte", required = false)
    var intituleCompte: String = "",

    @field:Element(name = "numero", required = false)
    var numero: String = "",

    @field:Element(name = "prelevementOk", required = false)
    var prelevementOk: Boolean = true,

    @field:Element(name = "typeCompte", required = false)
    var typeCompte: TypeCompte? = null,

    @field:Element(name = "typeMembre", required = false)
    var typeMembre: TypeMembre? = null,

//    @field:Element(name = "numeroIdMarchand", required = false)
//    var numeroIdMarchand: String
)