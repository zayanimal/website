package moscow.mech.website.service

import moscow.mech.website.domain.product.entity.CategoryEntity
import moscow.mech.website.domain.product.repository.ProductRepository
import moscow.mech.website.dto.product.Feature
import moscow.mech.website.dto.product.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService(
    @Autowired val productRepository: ProductRepository
) {

    fun getProducts(categoryId: Long): List<Product> {
        val products = productRepository.findByCategory(CategoryEntity(categoryId))

        return products.map { Product(
            it.id,
            it.caption,
            it.salePrice,
            it.category.name,
            it.features.map { f -> Feature(f.name, f.description) },
            it.pictures.map { p -> p.identification }
        ) }
    }
}
