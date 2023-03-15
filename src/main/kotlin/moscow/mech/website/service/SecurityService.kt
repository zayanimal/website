package moscow.mech.website.service

import moscow.mech.website.domain.auth.entity.AuthEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class SecurityService {

    fun getUserId(): Long = (SecurityContextHolder.getContext().authentication.principal as AuthEntity).id!!
}
