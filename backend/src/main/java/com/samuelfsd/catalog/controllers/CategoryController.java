package com.samuelfsd.catalog.controllers;

import com.samuelfsd.catalog.entities.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @GetMapping()
    public ResponseEntity<List<Category>> findAll(){
        List<Category> listCategories = new ArrayList<>();
        listCategories.add(new Category(1L, "Books"));
        listCategories.add(new Category(2L, "Electronics"));

        return ResponseEntity.ok().body(listCategories);
    }
}
