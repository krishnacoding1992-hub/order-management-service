package com.krishnacoding.oms.controller;

import com.krishnacoding.oms.entities.ProductEntity;
import com.krishnacoding.oms.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oms/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductEntity createProduct(@RequestBody ProductEntity productEntity) {
        productService.save(productEntity);
        return productEntity;
    }

    @GetMapping("/all")
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();

    }

    @GetMapping("/{id}")
    public ProductEntity getProductById(@PathVariable  long id) {
         return productService.getProductById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

    }

    @PutMapping("/{id}")
    public ProductEntity updateProduct(@PathVariable Long id, @RequestBody ProductEntity productEntity) {
        return productService.updateProductById(id,productEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id) {
         productService.removeProductById(id);
         return "Product with id: " + id + " has been deleted";
    }
}
