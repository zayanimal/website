package moscow.mech.website.service

import moscow.mech.website.domain.document.entity.StockEntity
import moscow.mech.website.domain.product.entity.CategoryEntity
import moscow.mech.website.domain.product.entity.PictureEntity
import moscow.mech.website.domain.product.repository.ProductRepository
import moscow.mech.website.dto.product.Feature
import moscow.mech.website.dto.product.Product
import moscow.mech.website.dto.product.ProductCard
import moscow.mech.website.dto.stock.Stock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class ProductService @Autowired constructor(
    val productRepository: ProductRepository,
    val entityManager: EntityManager
) {

    fun getProductCard(productId: Long): ProductCard {
        val product = productRepository.findById(productId).orElseThrow()
        val query = entityManager
            .createNamedQuery("stock_balances", StockEntity::class.java)
            .setParameter("id", productId)

        return ProductCard(
            product.id,
            product.title,
            product.price,
            product.caption,
            product.features.map { f -> Feature(f.name, f.description) },
            product.pictures.map { p -> p.identification },
            query.resultList.map{ s -> Stock(s.size, s.qty) }
        )
    }

    fun getProducts(categoryId: Long): List<Product> {
        val products = productRepository.findByCategory(CategoryEntity(categoryId))

        return products.map { Product(
            it.id,
            it.title,
            it.price,
            getPicture(it.pictures)
        ) }
    }

    private fun getPicture(pictures: List<PictureEntity>): String {
        return if (pictures.isEmpty()) "" else pictures.first().identification
    }
}
