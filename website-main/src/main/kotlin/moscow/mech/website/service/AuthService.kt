package moscow.mech.website.service

import moscow.mech.website.auth.JwtTokenService
import moscow.mech.website.constant.Role
import moscow.mech.website.domain.user.entity.AddressEntity
import moscow.mech.website.domain.user.entity.ContactEntity
import moscow.mech.website.domain.user.entity.RecipientEntity
import moscow.mech.website.domain.user.entity.UserEntity
import moscow.mech.website.domain.user.repository.*
import moscow.mech.website.dto.auth.AuthRegistration
import moscow.mech.website.dto.auth.AuthRequest
import moscow.mech.website.dto.auth.AuthResponse
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService @Autowired constructor(
    val userRepository: UserRepository,
    val roleRepository: RoleRepository,
    val passwordEncoder: PasswordEncoder,
    val authenticationManager: AuthenticationManager,
    val jwtTokenService: JwtTokenService
) {

    private val log = LoggerFactory.getLogger(this.javaClass)

    fun login(request: AuthRequest): AuthResponse {
        val authenticate = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(request.username, request.password))

        val user = authenticate.principal as UserDetails
        val token = jwtTokenService.generate(user)

        return AuthResponse(
            user.username,
            user.authorities.map { it.authority },
            token
        )
    }

    fun create(registration: AuthRegistration): UserEntity {
        val user = UserEntity(
            registration.username,
            passwordEncoder.encode(registration.password),
            listOf(roleRepository.findByName(Role.CUSTOMER.toString()).get()),
            registration.address.map { AddressEntity(it.index, it.city, it.street, it.home, it.flat) },
            registration.contact.map { ContactEntity(it.phone, it.email) },
            registration.recipient.map { RecipientEntity(it.surname, it.name, it.middleName) }
        )

        return userRepository.save(user)
    }
}
