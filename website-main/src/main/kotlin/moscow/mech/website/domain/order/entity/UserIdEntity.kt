package moscow.mech.website.domain.order.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "USERS")
class UserIdEntity (

    @Id
    val id: Long
)
