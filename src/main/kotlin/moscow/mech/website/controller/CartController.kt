package moscow.mech.website.controller

import moscow.mech.website.dto.cart.CartItem
import moscow.mech.website.dto.cart.CartItemCreate
import moscow.mech.website.service.CartService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("cart")
class CartController @Autowired constructor(
    val cartService: CartService
) {

    @GetMapping
    fun getAll(): List<CartItem> {
        return cartService.getAll()
    }

    @PutMapping
    fun create(@RequestBody item: CartItemCreate) {
        cartService.create(item)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        cartService.delete(id)
    }

    @DeleteMapping
    fun deleteAll() {
        cartService.deleteAll()
    }
}
