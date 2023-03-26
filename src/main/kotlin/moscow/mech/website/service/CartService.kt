package moscow.mech.website.service

import moscow.mech.website.domain.cart.entity.CartItemEntity
import moscow.mech.website.domain.cart.repository.ItemCardRepository
import moscow.mech.website.domain.document.entity.AttributeEntity
import moscow.mech.website.domain.product.entity.ProductEntity
import moscow.mech.website.domain.user.entity.UserEntity
import moscow.mech.website.dto.cart.CartItem
import moscow.mech.website.dto.cart.CartItemCreate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Service
class CartService @Autowired constructor(
    val securityService: SecurityService,
    val commonService: CommonService,
    val itemRepository: ItemCardRepository,
    val entityManager: EntityManager
) {

    fun getAll(): List<CartItem> = itemRepository.findByUserId(securityService.getUserId()).map {
        CartItem(
            it.id!!,
            it.qty,
            it.product.title,
            it.product.price,
            commonService.getPicture(it.product.pictures),
            it.attribute.name
        )
    }

    fun create(item: CartItemCreate) {
        itemRepository.save(CartItemEntity(
            item.qty,
            entityManager.getReference(UserEntity::class.java, securityService.getUserId()),
            entityManager.getReference(ProductEntity::class.java, item.productId),
            entityManager.getReference(AttributeEntity::class.java, item.attributeId)
        ))
    }

    fun delete(id: Long) {
        itemRepository.deleteById(id)
    }

    @Transactional
    fun deleteAll() {
        entityManager
            .createNamedQuery("delete_all_cart_items")
            .setParameter("id", securityService.getUserId())
            .executeUpdate()
    }
}
