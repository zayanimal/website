package moscow.mech.website.repositories

import moscow.mech.website.entities.Contact
import org.springframework.data.repository.CrudRepository

interface ContactRepository: CrudRepository<Contact, Long> {}
