package moscow.mech.website.controller

import moscow.mech.website.dto.user.Address
import moscow.mech.website.dto.user.User
import moscow.mech.website.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class UserController @Autowired constructor(val userService: UserService) {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @GetMapping
    fun get(): ResponseEntity<User> = ResponseEntity.ok(userService.get())

    @PutMapping
    fun createAddress(@RequestBody address: Address) {
        log.info(address.toString())
    }
}
