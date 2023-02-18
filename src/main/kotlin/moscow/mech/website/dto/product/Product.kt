package moscow.mech.website.dto.product

data class Product (

    val id: Long?,

    val caption: String,

    val price: Long,

    val category: String,

    val features: List<Feature>,

    val pictures: List<String>
)
