package moscow.mech.website.domain.order.repository

import moscow.mech.website.domain.order.entity.OrderEntity
import org.springframework.data.repository.CrudRepository

interface OrderRepository : CrudRepository<OrderEntity, Long> {

    fun findByUserId(userId: Long): List<OrderEntity>
}
