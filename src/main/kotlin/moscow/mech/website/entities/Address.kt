package moscow.mech.website.entities

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.OneToOne
import javax.persistence.JoinColumn

@Entity
@Table(name = "ADDRESSES")
data class Address(
    val idx: Int,
    @OneToOne @JoinColumn(name = "city_id") val city: City,
    val street: String,
    val home: String,
    val flat: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)
