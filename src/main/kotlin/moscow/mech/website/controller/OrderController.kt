package moscow.mech.website.controller

import moscow.mech.website.dto.order.ItemShortened
import moscow.mech.website.dto.order.Order
import moscow.mech.website.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController @Autowired constructor(val orderService: OrderService) {

    @GetMapping("/orders")
    fun getOrders(): ResponseEntity<List<Order>> {
        return ResponseEntity.ok(orderService.getOrders())
    }

    @PutMapping("/order/create")
    fun createOrder(@RequestBody order: List<ItemShortened>) {
        orderService.createOrder(order)
    }

    @DeleteMapping("/order/delete")
    fun deleteOrder() {

    }
}
