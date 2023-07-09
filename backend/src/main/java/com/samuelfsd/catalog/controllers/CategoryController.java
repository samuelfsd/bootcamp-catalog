package com.samuelfsd.catalog.controllers;

import com.samuelfsd.catalog.dto.CategoryDTO;
import com.samuelfsd.catalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAllCategories(){
        List<CategoryDTO> listCategories = service.findAllCategories();

        return ResponseEntity.ok().body(listCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findCategoryById(@PathVariable Long id){
        CategoryDTO categoryDTO = service.findCategoryById(id);

        return ResponseEntity.ok().body(categoryDTO);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO dto) {
        dto = service.createCategory(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();

        return ResponseEntity.created(uri).body(dto);
    }
}
