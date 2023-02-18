package moscow.mech.website.domain.product.entity

import javax.persistence.*

@Entity
@Table(name = "CATEGORIES")
class CategoryEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String
) {
    constructor(id: Long) : this(id, "")
}
