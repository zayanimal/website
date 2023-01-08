package moscow.mech.website.user.entities

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.OneToOne
import javax.persistence.JoinColumn

@Entity
@Table(name = "ADDRESSES")
class AddressEntity(
    val idx: String,

    @OneToOne
    @JoinColumn(name = "city_id")
    val city: CityEntity,

    val street: String,

    val home: String,

    val flat: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long
)
