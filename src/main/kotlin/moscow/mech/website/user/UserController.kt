package moscow.mech.website.user

import moscow.mech.website.user.dto.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController @Autowired constructor(val userService: UserService) {
    @GetMapping("/user")
    fun get(@RequestParam id: String): User {
        return userService.get(id.toLong())
    }
}
