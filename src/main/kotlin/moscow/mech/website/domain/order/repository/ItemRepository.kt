package moscow.mech.website.domain.order.repository

import moscow.mech.website.domain.order.entity.ItemEntity
import org.springframework.data.repository.CrudRepository

interface ItemRepository : CrudRepository<ItemEntity, Long> {}