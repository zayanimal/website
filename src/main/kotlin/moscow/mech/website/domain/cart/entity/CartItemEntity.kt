package moscow.mech.website.domain.cart.entity

import moscow.mech.website.domain.document.entity.AttributeEntity
import moscow.mech.website.domain.product.entity.ProductEntity
import moscow.mech.website.domain.user.entity.UserEntity
import javax.persistence.*

@NamedQuery(
    name = "delete_all_cart_items",
    query = "delete from CartItemEntity c where c.user.id = :id"
)
@Entity
@Table(name = "CART_ITEM")
class CartItemEntity (

    val qty: Long,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity,

    @ManyToOne
    @JoinColumn(name = "product_id")
    val product: ProductEntity,

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    val attribute: AttributeEntity,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)
