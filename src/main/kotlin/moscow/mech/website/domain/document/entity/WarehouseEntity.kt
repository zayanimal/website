package moscow.mech.website.domain.document.entity

import javax.persistence.*

@Entity
@Table(name = "WAREHOUSE")
class WarehouseEntity (

    val name: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)
