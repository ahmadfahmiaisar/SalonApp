package com.example.salonapp.data.response.merchant

import com.squareup.moshi.Json


data class MakeupMerchantDetailDto(
    @field:Json(name = "avatar")
    val avatar: String?,
    @field:Json(name = "description")
    val description: String?,
    @field:Json(name = "id")
    val id: String?,
    @field:Json(name = "image")
    val image: String?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "rating")
    val rating: String?,
    @field:Json(name = "services")
    val services: List<Service>?,
    @field:Json(name = "user_image")
    val userImage: String?
) {
    data class Service(
        @field:Json(name = "caption")
        val caption: String?,
        @field:Json(name = "name")
        val name: String?,
        @field:Json(name = "price")
        val price: String?
    )
}