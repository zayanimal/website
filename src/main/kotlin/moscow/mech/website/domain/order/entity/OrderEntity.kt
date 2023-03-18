package moscow.mech.website.domain.order.entity

import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "ORDERS")
class OrderEntity (

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserOrderEntity,

    @ManyToOne
    @JoinColumn(name = "status_id")
    val status: StatusEntity,

    @OrderBy("created DESC")
    val created: LocalDateTime,

    @OneToMany
    @JoinColumn(name = "order_id")
    @LazyCollection(LazyCollectionOption.EXTRA)
    var items: List<ItemEntity>? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)
