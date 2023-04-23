package moscow.mech.website.domain.product.entity

import javax.persistence.*

@Entity
@Table(name = "FEATURES")
class FeatureEntity (

    @Id
    val id: Long,

    val name: String,

    val description: String
)
