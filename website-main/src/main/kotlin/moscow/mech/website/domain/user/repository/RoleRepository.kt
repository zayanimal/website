package moscow.mech.website.domain.user.repository

import moscow.mech.website.constant.Role
import moscow.mech.website.domain.user.entity.RoleEntity
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface RoleRepository: CrudRepository<RoleEntity, Long> {

    fun findByName(name: String): Optional<RoleEntity>
}
