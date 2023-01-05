package moscow.mech.website.controllers

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/")
    fun getAll(): String {

        log.info("=== Start ===")

        return "Hello"
    }
}
