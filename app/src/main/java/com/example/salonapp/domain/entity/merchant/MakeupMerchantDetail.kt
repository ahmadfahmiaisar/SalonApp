package com.example.salonapp.domain.entity.merchant

data class MakeupMerchantDetail(
    val avatar: String,
    val description: String,
    val id: String,
    val image: String,
    val name: String,
    val rating: String,
    val services: List<Service>,
    val userImage: String
) {
    data class Service(
        val caption: String,
        val name: String,
        val price: String
    )
}
