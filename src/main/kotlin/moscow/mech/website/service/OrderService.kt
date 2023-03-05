package moscow.mech.website.service

import moscow.mech.website.domain.order.repository.OrderRepository
import moscow.mech.website.dto.order.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderService @Autowired constructor(
    val documentService: DocumentService,
    val orderRepository: OrderRepository,
) {

    fun getOrders(): List<Order> {
        val orders = orderRepository.findByUserId(1)



        return listOf()
    }

    fun createOrder() {

    }

    fun deleteOrder() {

    }
}
