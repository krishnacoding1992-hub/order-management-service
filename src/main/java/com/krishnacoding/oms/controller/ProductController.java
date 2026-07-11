package com.krishnacoding.oms.controller;

import com.krishnacoding.oms.entities.Products;
import com.krishnacoding.oms.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oms/products")
@RequiredArgsConstructor
public class ProductController {

    ProductServiceImpl productServiceImpl;

    @PostMapping
    public Products createProduct(@RequestBody Products products) {
        productServiceImpl.saveProduct(products);
        return products;
    }

    @GetMapping("/all")
    public List<Products> getAllProducts() {
        return productServiceImpl.getAllProducts();

    }

    @GetMapping("/{id}")
    public Products getProductById(@PathVariable  long id) {
         return productServiceImpl.getProductById(id);

    }

    @GetMapping("/subcategory/{subCategory}")
    public List<Products> getProductBySubCategory(@PathVariable  String subCategory) {
        return productServiceImpl.getProductBySubCategory(subCategory);
    }

    @PutMapping("/{id}")
    public Products updateProduct(@PathVariable Long id, @RequestBody Products products) {
        return productServiceImpl.updateProductById(id, products);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id) {
         productServiceImpl.deleteProductById(id);
         return "Product with id: " + id + " has been deleted";
    }
}
