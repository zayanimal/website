package moscow.mech.website.dto.product

import moscow.mech.website.dto.stock.Stock

data class Product (

    val id: Long?,

    val title: String,

    val caption: String,

    val price: Long,

    val category: String,

    val features: List<Feature>,

    val pictures: List<String>,

    val stock: List<Stock>
)
