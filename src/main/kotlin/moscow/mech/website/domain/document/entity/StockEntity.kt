package moscow.mech.website.domain.document.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.NamedQuery

@NamedQuery(
    name = "stock_balances",
    query = "select new StockEntity(a.id, a.name, sum(d.qty)) from DocumentEntity d " +
        "join AttributeEntity a on a.id = d.attribute.id " +
        "join WarehouseEntity we on we.id = d.warehouse.id " +
        "where d.product.id = :id and d.warehouse.id = 1 " +
        "group by a.name having sum(d.qty) > 0"
)
@Entity
class StockEntity (

    @Id
    val id: Long,

    val size: String,

    val qty: Long
)
