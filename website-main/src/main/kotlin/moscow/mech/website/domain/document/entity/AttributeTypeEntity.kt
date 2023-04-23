package moscow.mech.website.domain.document.entity

import javax.persistence.*

@Entity
@Table(name = "ATTRIBUTE_TYPE")
class AttributeTypeEntity (

    val name: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)
