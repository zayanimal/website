package moscow.mech.website.domain.order.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "USERS")
class UserOrderEntity (

    @Id
    val id: Long
)
