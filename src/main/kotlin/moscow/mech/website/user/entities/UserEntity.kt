package moscow.mech.website.user.entities

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.OneToOne
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Entity
@Table(name = "USERS")
data class UserEntity(
    val login: String,

    val password: String,

    @OneToOne
    @JoinColumn(name = "role_id")
    val role: RoleEntity,

    @OneToMany
    @JoinColumn(name = "user_id")
    val address: List<AddressEntity>,

    @OneToMany
    @JoinColumn(name = "user_id")
    val contact: List<ContactEntity>,

    @OneToMany
    @JoinColumn(name = "user_id")
    val recipient: List<RecipientEntity>,

    val defaultAddressId: Long,

    val defaultContactId: Long,

    val defaultRecipientId: Long,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long
)
