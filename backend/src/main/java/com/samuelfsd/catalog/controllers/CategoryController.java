package com.samuelfsd.catalog.controllers;

import com.samuelfsd.catalog.entities.Category;
import com.samuelfsd.catalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;
    @GetMapping()
    public ResponseEntity<List<Category>> findAllCategories(){
        List<Category> listCategories = service.findAllCategories();

        return ResponseEntity.ok().body(listCategories);
    }
}
