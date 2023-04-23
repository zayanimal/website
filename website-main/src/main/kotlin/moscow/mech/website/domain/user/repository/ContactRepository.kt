package moscow.mech.website.domain.user.repository

import moscow.mech.website.domain.user.entity.ContactEntity
import org.springframework.data.repository.CrudRepository

interface ContactRepository: CrudRepository<ContactEntity, Long> {}
