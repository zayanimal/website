package moscow.mech.website.repositories

import moscow.mech.website.entities.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long> {}
