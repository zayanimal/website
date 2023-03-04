package moscow.mech.website.domain.user.entity

import javax.persistence.*

@Entity
@Table(name = "ROLES")
class RoleEntity(

    @Id
    val id: Long,

    val name: String
)
