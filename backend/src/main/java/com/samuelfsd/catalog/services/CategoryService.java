package com.samuelfsd.catalog.services;

import com.samuelfsd.catalog.dto.CategoryDTO;
import com.samuelfsd.catalog.entities.Category;
import com.samuelfsd.catalog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;
    public List<CategoryDTO> findAllCategories(){
        List<Category> list = repository.findAll();

        List<CategoryDTO> listCategoriesDTO = list.stream().map(category -> new CategoryDTO(category)).collect(Collectors.toList());

        return listCategoriesDTO;
    }

    public CategoryDTO findCategoryById(Long id){
        Optional<Category> obj = repository.findById(id);
        Category category = obj.get();

        return new CategoryDTO(category);
    }
}
