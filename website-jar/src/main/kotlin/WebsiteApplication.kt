package moscow.mech.website

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["moscow.mech.website", "configuration"])
open class WebsiteApplication

fun main(args: Array<String>) {
	runApplication<WebsiteApplication>(*args)
}
