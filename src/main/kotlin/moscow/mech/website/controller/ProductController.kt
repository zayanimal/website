package moscow.mech.website.controller

import moscow.mech.website.dto.product.Product
import moscow.mech.website.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("products")
class ProductController (
    @Autowired val productService: ProductService
) {

    @GetMapping("/{categoryId}")
    fun getProducts(@PathVariable categoryId: Long): ResponseEntity<List<Product>> {
        return ResponseEntity.ok(productService.getProducts(categoryId))
    }
}
