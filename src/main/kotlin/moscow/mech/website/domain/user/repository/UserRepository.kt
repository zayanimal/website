package moscow.mech.website.domain.user.repository

import moscow.mech.website.domain.user.entity.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<UserEntity, Long> {}
