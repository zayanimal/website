package moscow.mech.website.dto.order

data class Item (
    val id: Long,

    val qty: Long,

    val title: String,

    val price: Long,

    val size: String,

    val picture: String?
)
