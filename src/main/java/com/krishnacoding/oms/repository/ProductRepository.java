package com.krishnacoding.oms.repository;

import com.krishnacoding.oms.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

    public List<Products> findBySubCategory(String subCategory);
}
