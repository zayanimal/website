package moscow.mech.website.domain.user.entity

import javax.persistence.*

@Entity
@Table(name = "CONTACTS")
class ContactEntity(

    val phone: String,

    val email: String,


    @Column(name = "user_id")
    val userId: Long? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)
