package moscow.mech.website.user.entities

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.OneToOne
import javax.persistence.ManyToOne
import javax.persistence.JoinColumn

@Entity
@Table(name = "USERS")
data class UserEntity(
    val login: String,

    val surname: String,

    val name: String,

    val middleName: String,

    val password: String,

    @OneToOne
    @JoinColumn(name = "role_id")
    val role: RoleEntity,

    @ManyToOne
    @JoinColumn(name = "address_id")
    val address: AddressEntity,

    @ManyToOne
    @JoinColumn(name = "contact_id")
    val contact: ContactEntity,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)
