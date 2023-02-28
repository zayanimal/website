package moscow.mech.website.controller

import moscow.mech.website.dto.product.Product
import moscow.mech.website.dto.product.ProductCard
import moscow.mech.website.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("product")
class ProductController (
    @Autowired val productService: ProductService
) {
    @GetMapping(params = ["id"])
    fun getProduct(@RequestParam id: Long): ResponseEntity<ProductCard> {
        return ResponseEntity.ok(productService.getProductCard(id))
    }

    @GetMapping(params = ["categoryId"])
    fun getProductsByCategory(@RequestParam categoryId: Long): ResponseEntity<List<Product>> {
        return ResponseEntity.ok(productService.getProducts(categoryId))
    }
}
