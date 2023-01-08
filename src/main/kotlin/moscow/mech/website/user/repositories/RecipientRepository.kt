package moscow.mech.website.user.repositories

import moscow.mech.website.user.entities.RecipientEntity
import org.springframework.data.repository.CrudRepository

interface RecipientRepository: CrudRepository<RecipientEntity, Long> {}
