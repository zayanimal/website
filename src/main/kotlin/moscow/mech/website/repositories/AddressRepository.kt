package moscow.mech.website.repositories

import moscow.mech.website.entities.Address
import org.springframework.data.repository.CrudRepository

interface AddressRepository: CrudRepository<Address, Long> {}
