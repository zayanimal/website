package moscow.mech.website.domain.order.entity

import javax.persistence.*

@Entity
@Table(name = "ORDERS_STATUS")
class StatusEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val name: String
)
