package com.krishnacoding.oms.service;

import com.krishnacoding.oms.entities.Products;
import com.krishnacoding.oms.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {

    void saveProduct(Products products);

    Products getProductById(Long id) throws ProductNotFoundException;

    List<Products> getAllProducts();

    Products updateProductById(Long id, Products products);

    void deleteProductById(Long id);
}
