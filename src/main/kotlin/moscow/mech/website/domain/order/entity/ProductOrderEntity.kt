package moscow.mech.website.domain.order.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "PRODUCTS")
class ProductOrderEntity (

    @Id
    val id: Long,

    val title: String,

    val price: Long
)
