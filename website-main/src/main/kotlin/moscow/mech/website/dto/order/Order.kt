package moscow.mech.website.dto.order

import java.time.LocalDateTime

data class Order (

    val id: Long,

    val created: LocalDateTime,

    val status: Status,

    val product: List<Item>
)
