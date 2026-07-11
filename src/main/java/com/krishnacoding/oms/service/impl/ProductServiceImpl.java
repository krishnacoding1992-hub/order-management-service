package com.krishnacoding.oms.service.impl;

import com.krishnacoding.oms.entities.Products;
import com.krishnacoding.oms.exception.ProductNotFoundException;
import com.krishnacoding.oms.repository.ProductRepository;
import com.krishnacoding.oms.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Override
    public void saveProduct(Products products) {
        productRepository.save(products);
    }

    @Override
    public Products getProductById(Long id) throws ProductNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    public List<Products> getProductBySubCategory(String subCategory) {
        List<Products> products = productRepository.findBySubCategory(subCategory);

        if (products.isEmpty()) {
            throw new ProductNotFoundException(
                    "No products found for subcategory: " + subCategory
            );
        }
        return products;
    }

    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Products updateProductById(Long id, Products products) {
        Products existingProduct = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        existingProduct.setProductCode(products.getProductCode());
        existingProduct.setProductName(products.getProductName());
        existingProduct.setProductDescription(products.getProductDescription());
        existingProduct.setCategory(products.getCategory());
        existingProduct.setSubCategory(products.getSubCategory());
        existingProduct.setPrice(products.getPrice());
        existingProduct.setActive(products.isActive());
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProductById(Long id) {
        Products product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        productRepository.delete(product);
    }

}
