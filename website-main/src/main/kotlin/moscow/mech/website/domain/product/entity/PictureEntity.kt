package moscow.mech.website.domain.product.entity

import javax.persistence.*

@Entity
@Table(name = "PICTURES")
class PictureEntity (

    val identification: String,

    @Id
    val id: Long
)
