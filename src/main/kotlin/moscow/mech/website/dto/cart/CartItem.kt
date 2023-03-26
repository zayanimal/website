package moscow.mech.website.dto.cart

data class CartItem (

    val id: Long,

    val qty: Long,

    val title: String,

    val price: Long,

    val picture: String,

    val attribute: String
)
