package moscow.mech.website.domain.user.entity

import javax.persistence.*

@Entity
@Table(name = "RECIPIENTS")
class RecipientEntity(

    val surname: String,

    val name: String,

    val middleName: String,


    @Column(name = "user_id")
    val userId: Long? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)
