package com.rk.apiintegration.NewsAPI

data class Item(
    val Name: String,
    val _created: Double,
    val _data_type: String,
    val _is_deleted: Boolean,
    val _modified: Double,
    val _self_link: String,
    val _user: String,
    val _uuid: String,
    val active: Boolean
)