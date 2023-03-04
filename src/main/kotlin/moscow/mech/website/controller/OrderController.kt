package moscow.mech.website.controller

import moscow.mech.website.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController @Autowired constructor(val orderService: OrderService) {

    @GetMapping("/orders")
    fun getOrders() {
        val order = orderService.getOrder()
    }

    @PutMapping("/order/create")
    fun createOrder() {

    }

    @DeleteMapping("/order/delete")
    fun deleteOrder() {

    }
}
