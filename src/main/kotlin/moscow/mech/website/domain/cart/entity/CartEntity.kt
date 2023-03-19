package moscow.mech.website.domain.cart.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class CartEntity (

    @Id
    val id: Long
)
