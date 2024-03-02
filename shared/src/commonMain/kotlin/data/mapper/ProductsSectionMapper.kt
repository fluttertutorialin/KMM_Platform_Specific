package data.mapper

import data.componentdata.ProductComponentData
import domain.model.ProductResponseDomain

class ProductsSectionMapper : BaseMapper<List<ProductResponseDomain>, List<ProductComponentData>> {
    override suspend fun map(from: List<ProductResponseDomain>): List<ProductComponentData> {
        return from.map {
            ProductComponentData(
                id = it.id.toString(),
                image = it.image,
                title = it.title,
                desc = it.desc
            )
        }
    }
}