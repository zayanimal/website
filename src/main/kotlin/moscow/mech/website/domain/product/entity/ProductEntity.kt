package moscow.mech.website.domain.product.entity

import javax.persistence.*

@Entity
@Table(name = "PRODUCTS")
class ProductEntity (

    @Id
    val id: Long,

    val title: String,

    val caption: String,

    val price: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    val category: CategoryEntity,

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    val features: List<FeatureEntity>,

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    val pictures: List<PictureEntity>
)
