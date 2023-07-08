package com.samuelfsd.catalog.services;

import com.samuelfsd.catalog.entities.Category;
import com.samuelfsd.catalog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;
    public List<Category> findAllCategories(){
        return repository.findAll();
    }
}
