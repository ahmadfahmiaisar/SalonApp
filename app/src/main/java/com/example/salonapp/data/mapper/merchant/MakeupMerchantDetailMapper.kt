package com.example.salonapp.data.mapper.merchant

import com.example.base.abstraction.Mapper
import com.example.salonapp.data.response.merchant.MakeupMerchantDetailDto
import com.example.salonapp.domain.entity.merchant.MakeupMerchantDetail
import javax.inject.Inject

class MakeupMerchantDetailMapper @Inject constructor() :
    Mapper<MakeupMerchantDetailDto, MakeupMerchantDetail> {
    override fun map(input: MakeupMerchantDetailDto): MakeupMerchantDetail {
        return MakeupMerchantDetail(
            avatar = input.avatar ?: "",
            description = input.description ?: "",
            id = input.id ?: "",
            image = input.image ?: "",
            name = input.name ?: "",
            rating = input.rating ?: "",
            services = mapService(input.services),
            userImage = input.userImage ?: ""
        )
    }

    private fun mapService(input: List<MakeupMerchantDetailDto.Service>?): List<MakeupMerchantDetail.Service> {
        val service = mutableListOf<MakeupMerchantDetail.Service>()
        input?.forEach {
            service.add(
                MakeupMerchantDetail.Service(
                    name = it.name ?: "",
                    price = it.price ?: "",
                    caption = it.caption ?: ""
                )
            )
        }
        return service
    }
}
