package io.guidemy.learn.productwishlistdemo.controller;

import io.guidemy.learn.productwishlistdemo.exception.ResourceNotFoundException;
import io.guidemy.learn.productwishlistdemo.dto.response.ProductResponseDTO;
import io.guidemy.learn.productwishlistdemo.mapper.ProductMapper;
import io.guidemy.learn.productwishlistdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductResponseDTO> findAllProducts(){
        return productService.findAll().stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{productId}")
    public ProductResponseDTO findProductById(@PathVariable("productId")Long productId) throws ResourceNotFoundException{
        return productMapper.toDTO(productService.findById(productId));
    }
}
