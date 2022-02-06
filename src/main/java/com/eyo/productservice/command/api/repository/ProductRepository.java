package com.eyo.productservice.command.api.repository;

import com.eyo.productservice.command.api.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
