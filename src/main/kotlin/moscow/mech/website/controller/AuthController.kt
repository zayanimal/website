package moscow.mech.website.controller

import moscow.mech.website.dto.auth.AuthRegistration
import moscow.mech.website.dto.auth.AuthRequest
import moscow.mech.website.dto.auth.AuthResponse
import moscow.mech.website.domain.user.entity.UserEntity
import moscow.mech.website.service.AuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController @Autowired constructor(val authService: AuthService) {

    @PostMapping("login")
    fun login(@RequestBody request: AuthRequest): ResponseEntity<AuthResponse> = ResponseEntity
        .ok()
        .body(authService.login(request))

    @PutMapping("register")
    fun register(@RequestBody registration: AuthRegistration): UserEntity = authService.create(registration)
}
