package moscow.mech.website.user.repositories

import moscow.mech.website.user.entities.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<UserEntity, Long> {}
