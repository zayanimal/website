package moscow.mech.website.domain.product.repository

import moscow.mech.website.domain.section.entity.CategoryEntity
import moscow.mech.website.domain.product.entity.ProductEntity
import org.springframework.data.repository.CrudRepository

interface ProductRepository : CrudRepository<ProductEntity, Long> {

    fun findByCategory(category: CategoryEntity): List<ProductEntity>
}
