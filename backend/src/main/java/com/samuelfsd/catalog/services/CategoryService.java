package com.samuelfsd.catalog.services;

import com.samuelfsd.catalog.dto.CategoryDTO;
import com.samuelfsd.catalog.entities.Category;
import com.samuelfsd.catalog.exceptions.DatabaseException;
import com.samuelfsd.catalog.exceptions.ResourceNotFoundException;
import com.samuelfsd.catalog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional
    public List<CategoryDTO> findAllCategories(){
        List<Category> list = repository.findAll();

        List<CategoryDTO> listCategoriesDTO = list.stream().map(category -> new CategoryDTO(category)).collect(Collectors.toList());

        return listCategoriesDTO;
    }

    @Transactional
    public CategoryDTO findCategoryById(Long id){
        Optional<Category> obj = repository.findById(id);
        Category category = obj.orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));

        return new CategoryDTO(category);
    }

    @Transactional
    public CategoryDTO createCategory(CategoryDTO dto) {
        Category entity = new Category();
        entity.setName(dto.getName());

        entity = repository.save(entity);

        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO updateCategoryById(Long id, CategoryDTO dto) {
        try {
            Category entity = repository.getOne(id);
            entity.setName(dto.getName());

            entity = repository.save(entity);

            return new CategoryDTO(entity);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Não existe nenhuma categoria com este ID");
        }
    }

    public void deleteCategory(Long id) {
        try {
            repository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Não existe nenhuma categoria com este ID");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade");
        }

    }
}
