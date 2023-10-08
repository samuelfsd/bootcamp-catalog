package com.samuelfsd.catalog.repositories;

import com.samuelfsd.catalog.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
