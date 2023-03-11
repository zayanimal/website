package moscow.mech.website.domain.order.entity

import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "ORDERS")
class OrderEntity (

    @Id
    val id: Long,

    @OrderBy("created DESC")
    val created: LocalDateTime,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserOrderEntity,

    @OneToMany
    @JoinColumn(name = "order_id")
    @LazyCollection(LazyCollectionOption.EXTRA)
    val items: List<ItemEntity>
)
