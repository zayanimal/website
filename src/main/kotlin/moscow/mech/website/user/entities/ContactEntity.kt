package moscow.mech.website.user.entities

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
@Table(name = "CONTACTS")
data class ContactEntity(
    val phone: String,

    val email: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long
)
