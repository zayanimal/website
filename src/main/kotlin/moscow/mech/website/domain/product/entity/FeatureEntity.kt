package moscow.mech.website.domain.product.entity

import javax.persistence.*

@Entity
@Table(name = "FEATURES")
class FeatureEntity (

    val name: String,

    val description: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)
