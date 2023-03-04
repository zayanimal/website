package moscow.mech.website.service

import moscow.mech.website.domain.order.entity.OrderEntity
import moscow.mech.website.domain.order.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class OrderService @Autowired constructor(
    val documentService: DocumentService,
    val orderRepository: OrderRepository
) {

    fun getOrder(): OrderEntity {
        val user = SecurityContextHolder.getContext().authentication.principal


        val order = orderRepository.findById(1)

        return order.get()
    }

    fun createOrder() {

    }

    fun deleteOrder() {

    }
}
