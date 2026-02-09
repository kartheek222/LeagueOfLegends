package com.ad_coding.mvvmcourse.ui.unil

import kotlinx.serialization.Serializable

@Serializable
data object ChampionList

@Serializable
data class ChampionDetails(val name: String)