package moscow.mech.website.entities

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
@Table(name = "CONTACTS")
class Contact(
    val phone: String,
    val email: String,
    val telegram: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)
