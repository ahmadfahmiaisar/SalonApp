package com.example.salonapp.data.mapper.merchant

import com.example.base.abstraction.Mapper
import com.example.salonapp.data.response.merchant.MakeupMerchantDto
import com.example.salonapp.domain.entity.merchant.MakeupMerchant
import javax.inject.Inject

class MakeupMerchantMapper @Inject constructor() :
    Mapper<List<MakeupMerchantDto>, List<MakeupMerchant>> {
    override fun map(input: List<MakeupMerchantDto>): List<MakeupMerchant> {
        val merchants = mutableListOf<MakeupMerchant>()
        input.forEach {
            merchants.add(
                MakeupMerchant(
                    avatar = it.avatar ?: "",
                    description = it.description ?: "",
                    id = it.id ?: "",
                    image = it.image ?: "",
                    name = it.name ?: "",
                    rating = it.rating ?: "",
                    services = mapService(it.services),
                    userImage = it.userImage ?: ""
                )
            )
        }
        return merchants
    }

    private fun mapService(input: List<MakeupMerchantDto.Service>?): List<MakeupMerchant.Service> {
        val service = mutableListOf<MakeupMerchant.Service>()
        input?.forEach {
            service.add(MakeupMerchant.Service(name = it.name ?: ""))
        }
        return service
    }
}