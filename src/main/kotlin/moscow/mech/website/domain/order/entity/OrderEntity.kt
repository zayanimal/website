package moscow.mech.website.domain.order.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "ORDERS")
class OrderEntity (

    @Id
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserOrderEntity,

    @ManyToMany
    @JoinTable(
        name = "orders_products",
        joinColumns = [JoinColumn(name = "order_id")],
        inverseJoinColumns = [JoinColumn(name = "product_id")]
    )
    val product: List<ProductOrderEntity>
)
