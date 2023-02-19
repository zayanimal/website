package moscow.mech.website.domain.product.entity

import javax.persistence.*

@Entity
@Table(name = "PRODUCTS")
class ProductEntity (

    val title: String,

    val caption: String,

    val price: Long,

    @ManyToOne
    val category: CategoryEntity,

    @OneToMany
    @JoinColumn(name = "product_id")
    val features: List<FeatureEntity>,

    @OneToMany
    @JoinColumn(name = "product_id")
    val pictures: List<PictureEntity>,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)
