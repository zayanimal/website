package moscow.mech.website.controller

import moscow.mech.website.dto.auth.AuthRegistration
import moscow.mech.website.dto.auth.AuthRequest
import moscow.mech.website.dto.auth.AuthResponse
import moscow.mech.website.auth.JwtTokenService
import moscow.mech.website.domain.user.entity.UserEntity
import moscow.mech.website.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(
    @Autowired val authenticationManager: AuthenticationManager,
    @Autowired val jwtTokenService: JwtTokenService,
    @Autowired val userService: UserService
) {

    @PostMapping("login")
    fun login(@RequestBody request: AuthRequest): ResponseEntity<AuthResponse> {
        val authenticate = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(request.username, request.password))

        val user = authenticate.principal as UserDetails
        val token = jwtTokenService.generate(user);

        return ResponseEntity.ok()
            .body(
                AuthResponse(
                user.username,
                user.authorities.map { it.authority },
                token
            )
            )
    }

    @PutMapping("register")
    fun register(@RequestBody registration: AuthRegistration): UserEntity {
        return userService.create(registration)
    }
}
