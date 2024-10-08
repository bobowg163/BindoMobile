package com.example.bindomobile.data.datasource.remote.dtos

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

/**
 * @author bobo
 * @project BindoMobile
 * @date 2024/10/5
 * @time 下午2:18
 * @month_full 十月
 * @day 05
 * @day_full 星期六
 * @minute 18
 */

@Root(name = "compteSFDs")
data class CompteSFDs(
    @field:ElementList(name = "compteSFDs", entry = "compte", inline = true, required = false)
    var compteSFDs: MutableList<Compte> = mutableListOf()
)