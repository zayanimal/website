package moscow.mech.website.domain.user.entity

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
@Table(name = "ADDRESSES")
class AddressEntity(
    val idx: String,

    val city: String,

    val street: String,

    val home: String,

    val flat: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)
