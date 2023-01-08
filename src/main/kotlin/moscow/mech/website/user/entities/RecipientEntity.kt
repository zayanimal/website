package moscow.mech.website.user.entities

import javax.persistence.*

@Entity
@Table(name = "RECIPIENTS")
data class RecipientEntity(
    val surname: String,

    val name: String,

    val middleName: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long
)
