package moscow.mech.website.domain.cart.repository

import moscow.mech.website.domain.cart.entity.CartItemEntity
import org.springframework.data.repository.CrudRepository

interface ItemCardRepository : CrudRepository<CartItemEntity, Long> {

    fun findByUserId(userId: Long): List<CartItemEntity>
}
