package com.krishnacoding.oms.service;

import com.krishnacoding.oms.entities.ProductEntity;
import com.krishnacoding.oms.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(ProductEntity productEntity) {
        productRepository.save(productEntity);
    }

    public Optional<ProductEntity> getProductById(Long id) {
        return productRepository.findById(id);
    }


    public ProductEntity updateProductById(Long id ,ProductEntity productEntity) {
        ProductEntity existingProduct = productRepository.findById(id).get();
        existingProduct.setProductCode(productEntity.getProductCode());
        existingProduct.setProductName(productEntity.getProductName());
        existingProduct.setProductDescription(productEntity.getProductDescription());
        existingProduct.setCategory(productEntity.getCategory());
        existingProduct.setSubCategory(productEntity.getSubCategory());
        existingProduct.setPrice(productEntity.getPrice());
        existingProduct.setActive(productEntity.isActive());
        return productRepository.save(existingProduct);
    }

    public void removeProductById(Long id) {
        productRepository.deleteById(id);
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
}
