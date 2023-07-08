package com.samuelfsd.catalog.repositories;

import com.samuelfsd.catalog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
