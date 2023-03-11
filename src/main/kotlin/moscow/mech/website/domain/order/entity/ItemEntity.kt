package moscow.mech.website.domain.order.entity

import moscow.mech.website.domain.document.entity.AttributeEntity
import moscow.mech.website.domain.document.entity.DocumentEntity
import moscow.mech.website.domain.product.entity.ProductEntity
import javax.persistence.*

@Entity
@Table(name = "ORDERS_ITEM")
class ItemEntity (

    @Id
    val id: Long,

    val qty: Long,

    @ManyToOne
    @JoinColumn(name = "product_id")
    val product: ProductEntity,

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    val attribute: AttributeEntity,

    @OneToOne
    @JoinTable(
        name = "orders_documents",
        joinColumns = [JoinColumn(name = "order_item_id")],
        inverseJoinColumns = [JoinColumn(name = "document_id")]
    )
    val documents: DocumentEntity
)
