package moscow.mech.website.domain.cart.repository

import moscow.mech.website.domain.cart.entity.CartEntity
import org.springframework.data.repository.CrudRepository

interface CartRepository : CrudRepository<CartEntity, Long> {}
