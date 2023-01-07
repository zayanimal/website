package moscow.mech.website.user.repositories

import moscow.mech.website.user.entities.ContactEntity
import org.springframework.data.repository.CrudRepository

interface ContactRepository: CrudRepository<ContactEntity, Long> {}
