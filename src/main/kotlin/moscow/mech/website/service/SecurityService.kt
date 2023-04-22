package moscow.mech.website.service

import moscow.mech.website.domain.auth.entity.AuthEntity
import moscow.mech.website.exception.BadUserException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class SecurityService {

    fun checkUser(userId: Long, operation: () -> Unit) {
        if (userId == getUserId()) {
            operation.invoke()
        } else {
            throw BadUserException("Пользователь не хранится в сессии")
        }
    }

    fun getUserId(): Long = (SecurityContextHolder.getContext().authentication.principal as AuthEntity).id!!
}
