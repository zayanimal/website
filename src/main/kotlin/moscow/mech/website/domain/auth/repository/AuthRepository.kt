package moscow.mech.website.domain.auth.repository

import moscow.mech.website.domain.auth.entity.AuthEntity
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface AuthRepository: CrudRepository<AuthEntity, Long> {

    fun findByLogin(name: String): Optional<AuthEntity>
}