package moscow.mech.website.domain.user.repository

import moscow.mech.website.domain.user.entity.RecipientEntity
import org.springframework.data.repository.CrudRepository

interface RecipientRepository: CrudRepository<RecipientEntity, Long> {}
