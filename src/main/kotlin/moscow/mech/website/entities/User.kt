package moscow.mech.website.entities

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
data class User(
    val login: String,
    val password: String,
    @OneToOne @JoinColumn(name = "role_id") val role: Role,
    @ManyToOne @JoinColumn(name = "address_id") val address: Address,
    @ManyToOne @JoinColumn(name = "contact_id") val contact: Contact,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)
