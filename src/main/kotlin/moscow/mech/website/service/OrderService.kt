package moscow.mech.website.service

import moscow.mech.website.domain.auth.entity.AuthEntity
import moscow.mech.website.domain.order.repository.OrderRepository
import moscow.mech.website.domain.product.entity.PictureEntity
import moscow.mech.website.dto.order.Item
import moscow.mech.website.dto.order.ItemShortened
import moscow.mech.website.dto.order.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class OrderService @Autowired constructor(
    val documentService: DocumentService,
    val orderRepository: OrderRepository,
) {

    fun getOrders(): List<Order> {
        val user = SecurityContextHolder.getContext().authentication.principal as AuthEntity

        orderRepository.findByUserId(user.id!!) ?.let { return it.map { o -> Order(
            o.id,
            o.created,
            o.items.stream().map { i -> Item(
                i.id,
                i.qty,
                i.product.title,
                i.product.price,
                i.attribute.name,
                getPicture(i.product.pictures)
            ) }.toList()) }
        }

        return listOf()
    }

    private fun getPicture(pictures: List<PictureEntity>?): String? = if (!pictures.isNullOrEmpty())
        pictures.first().identification else null

    fun createOrder(order: List<ItemShortened>) {
        val res = order
    }

    fun deleteOrder() {

    }
}
