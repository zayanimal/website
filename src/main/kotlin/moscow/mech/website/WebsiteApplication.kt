package moscow.mech.website

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebsiteApplication

fun main(args: Array<String>) {
	runApplication<WebsiteApplication>(*args)
}
