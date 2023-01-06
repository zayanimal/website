package moscow.mech.website.entities

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
@Table(name = "ROLES")
data class Role(
    val name: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)
