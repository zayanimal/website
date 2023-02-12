package moscow.mech.website.domain.user.entity

import javax.persistence.*

@Entity
@Table(name = "ROLES")
class RoleEntity(

    val name: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long
)
