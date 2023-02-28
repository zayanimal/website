package moscow.mech.website.dto.product

import moscow.mech.website.dto.stock.Stock

data class ProductCard (

    val id: Long,

    val title: String,

    val price: Long,

    val caption: String,

    val features: List<Feature>,

    val pictures: List<String>,

    val stock: List<Stock>
)
