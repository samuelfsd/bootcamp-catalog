package com.samuelfsd.catalog.services;

import com.samuelfsd.catalog.dtos.ProductDTO;
import com.samuelfsd.catalog.entities.Product;
import com.samuelfsd.catalog.exceptions.ResourceNotFoundException;
import com.samuelfsd.catalog.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional
    public ProductDTO findProductById(Long id) {
        Optional<Product> obj = repository.findById(id);
        Product product = obj.orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado."));

        return new ProductDTO(product);
    }

    @Transactional
    public Page<ProductDTO> findAllProductsPaged(PageRequest pageRequest) {
        Page<Product> list = repository.findAll(pageRequest);
        Page<ProductDTO> productListDto = list.map(ProductDTO::new);

        return productListDto;
    }
}
