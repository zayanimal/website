package moscow.mech.website.service

import moscow.mech.website.domain.document.entity.AttributeEntity
import moscow.mech.website.domain.document.entity.DocumentEntity
import moscow.mech.website.domain.document.entity.DocumentTypeEntity
import moscow.mech.website.domain.document.entity.WarehouseEntity
import moscow.mech.website.domain.document.repository.DocumentRepository
import moscow.mech.website.domain.order.entity.ItemEntity
import moscow.mech.website.domain.order.entity.OrderEntity
import moscow.mech.website.domain.order.entity.StatusEntity
import moscow.mech.website.domain.order.entity.UserOrderEntity
import moscow.mech.website.domain.order.repository.ItemRepository
import moscow.mech.website.domain.order.repository.OrderRepository
import moscow.mech.website.domain.product.entity.PictureEntity
import moscow.mech.website.domain.product.entity.ProductEntity
import moscow.mech.website.domain.user.entity.UserEntity
import moscow.mech.website.dto.order.Item
import moscow.mech.website.dto.order.ItemShortened
import moscow.mech.website.dto.order.Order
import moscow.mech.website.dto.order.Status
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.persistence.EntityManager
import kotlin.streams.toList

@Service
class OrderService @Autowired constructor(
    val securityService: SecurityService,
    val documentRepository: DocumentRepository,
    val orderRepository: OrderRepository,
    val itemRepository: ItemRepository,
    val entityManager: EntityManager
) {

    fun getOrders(): List<Order> {
        orderRepository.findByUserId(securityService.getUserId()) ?.let { return it.map { o -> Order(
            o.id!!,
            o.created,
            Status(o.status.id, o.status.name),
            o.items!!.stream().map { i -> Item(
                i.product.id,
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
        val userId = securityService.getUserId()
        val orderEntity = orderRepository.save(OrderEntity(
            UserOrderEntity(userId),
            entityManager.getReference(StatusEntity::class.java, 1L),
            LocalDateTime.now()))

        val documents = documentRepository.saveAll(order.map { o -> DocumentEntity(
            -o.qty,
            entityManager.getReference(UserEntity::class.java, userId),
            entityManager.getReference(DocumentTypeEntity::class.java, 3L),
            entityManager.getReference(ProductEntity::class.java, o.id),
            entityManager.getReference(AttributeEntity::class.java, o.attributeId),
            entityManager.getReference(WarehouseEntity::class.java, 1L),
        )})

        itemRepository.saveAll(documents.map { document -> ItemEntity(
            document.qty * -1,
            orderEntity,
            document.product,
            document.attribute,
            document
        ) })
    }

    fun deleteOrder() {

    }
}
