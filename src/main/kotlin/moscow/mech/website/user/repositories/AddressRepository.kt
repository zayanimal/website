package moscow.mech.website.user.repositories

import moscow.mech.website.user.entities.AddressEntity
import org.springframework.data.repository.CrudRepository

interface AddressRepository: CrudRepository<AddressEntity, Long> {}
