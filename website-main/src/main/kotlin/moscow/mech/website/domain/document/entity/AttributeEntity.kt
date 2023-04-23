package moscow.mech.website.domain.document.entity

import javax.persistence.*

@Entity
@Table(name = "ATTRIBUTES")
class AttributeEntity (

    val name: String,

    @OneToOne
    @JoinColumn(name = "type_id")
    val type: AttributeTypeEntity,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)
