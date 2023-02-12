package moscow.mech.website.controller

import moscow.mech.website.dto.user.User
import moscow.mech.website.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController @Autowired constructor(val userService: UserService) {

    @GetMapping("/user")
    fun get(@RequestParam id: String): ResponseEntity<User> = ResponseEntity.ok(userService.get(id.toLong()))
}
