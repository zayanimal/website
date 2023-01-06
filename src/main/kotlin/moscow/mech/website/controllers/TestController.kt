package moscow.mech.website.controllers

import moscow.mech.website.repositories.AddressRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController @Autowired constructor(
    val repository: AddressRepository
) {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @GetMapping
    fun getAll(): String {

        log.info("=== Start ===")

        return "Hello"
    }
}
