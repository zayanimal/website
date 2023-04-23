package moscow.mech.website.domain.auth.entity

import moscow.mech.website.domain.user.entity.RoleEntity
import javax.persistence.*

@Entity
@Table(name = "USERS")
class AuthEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    val login: String,

    val password: String,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    val role: List<RoleEntity>
)
