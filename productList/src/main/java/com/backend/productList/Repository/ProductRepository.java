package com.backend.productList.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.productList.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
