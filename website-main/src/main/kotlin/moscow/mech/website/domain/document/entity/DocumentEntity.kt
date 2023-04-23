package moscow.mech.website.domain.document.entity

import moscow.mech.website.domain.product.entity.ProductEntity
import moscow.mech.website.domain.user.entity.UserEntity
import javax.persistence.*

@Entity
@Table(name = "DOCUMENTS")
class DocumentEntity (

    val qty: Long,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity,

    @ManyToOne
    @JoinColumn(name = "type_id")
    val type: DocumentTypeEntity,

    @ManyToOne
    @JoinColumn(name = "product_id")
    val product: ProductEntity,

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    val attribute: AttributeEntity,

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    val warehouse: WarehouseEntity,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)
