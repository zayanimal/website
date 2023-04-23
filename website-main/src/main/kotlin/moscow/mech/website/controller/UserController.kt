package moscow.mech.website.controller

import moscow.mech.website.dto.user.Address
import moscow.mech.website.dto.user.Contact
import moscow.mech.website.dto.user.Recipient
import moscow.mech.website.dto.user.User
import moscow.mech.website.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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

    @PutMapping("/address")
    fun createAddress(@RequestBody address: Address): ResponseEntity<String> {
        userService.createAddress(address)
        return ResponseEntity.ok("Адрес добавлен")
    }

    @DeleteMapping("/address/{id}")
    fun deleteAddress(@PathVariable id: Long): ResponseEntity<String> {
        userService.deleteAddress(id)
        return ResponseEntity.ok("Адрес удалён")
    }

    @PutMapping("/contact")
    fun createContact(@RequestBody contact: Contact): ResponseEntity<String> {
        userService.createContact(contact)
        return ResponseEntity.ok("Контактная информация добавлена")
    }

    @DeleteMapping("/contact/{id}")
    fun deleteContact(@PathVariable id: Long): ResponseEntity<String> {
        userService.deleteContact(id)
        return ResponseEntity.ok("Контактная информация удалена")
    }

    @PutMapping("/recipient")
    fun createRecipient(@RequestBody recipient: Recipient): ResponseEntity<String> {
        userService.createRecipient(recipient)
        return ResponseEntity.ok("Получатель добавлен")
    }

    @DeleteMapping("/recipient/{id}")
    fun deleteRecipient(@PathVariable id: Long): ResponseEntity<String> {
        userService.deleteRecipient(id)
        return ResponseEntity.ok("Получатель удалён")
    }
}
