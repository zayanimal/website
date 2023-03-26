package moscow.mech.website.dto.cart

data class CartItemCreate (

    val qty: Long,

    val productId: Long,

    val attributeId: Long
)
