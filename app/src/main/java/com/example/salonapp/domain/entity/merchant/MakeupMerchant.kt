package com.example.salonapp.domain.entity.merchant

data class MakeupMerchant(
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
        val name: String
    )
}
