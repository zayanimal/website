package moscow.mech.website.domain.user.repository

import moscow.mech.website.domain.user.entity.AddressEntity
import org.springframework.data.repository.CrudRepository

interface AddressRepository: CrudRepository<AddressEntity, Long> {}
