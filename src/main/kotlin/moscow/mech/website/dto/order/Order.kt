package moscow.mech.website.dto.order

import java.time.LocalDateTime

data class Order (

    val id: Long,

    val created: LocalDateTime,

    val product: List<ProductOrder>
)
