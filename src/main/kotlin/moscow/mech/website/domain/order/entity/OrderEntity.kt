package moscow.mech.website.domain.order.entity

import moscow.mech.website.domain.document.entity.AttributeEntity
import moscow.mech.website.domain.document.entity.DocumentEntity
import moscow.mech.website.domain.product.entity.ProductEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "ORDERS")
class OrderEntity (

    @Id
    val id: Long,

    @OrderBy("created DESC")
    val created: LocalDateTime,

    val qty: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: UserOrderEntity,

    @ManyToOne
    val product: ProductEntity,

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    val attribute: AttributeEntity,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(
        name = "orders_documents",
        joinColumns = [JoinColumn(name = "order_id")],
        inverseJoinColumns = [JoinColumn(name = "document_id")]
    )
    val documents: DocumentEntity
)
