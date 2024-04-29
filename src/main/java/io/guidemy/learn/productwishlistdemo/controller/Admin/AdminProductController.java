package io.guidemy.learn.productwishlistdemo.controller.Admin;

import io.guidemy.learn.productwishlistdemo.exception.ResourceNotFoundException;
import io.guidemy.learn.productwishlistdemo.dto.request.ProductRequestDTO;
import io.guidemy.learn.productwishlistdemo.dto.response.ProductResponseDTO;
import io.guidemy.learn.productwishlistdemo.mapper.ProductMapper;
import io.guidemy.learn.productwishlistdemo.model.Product;
import io.guidemy.learn.productwishlistdemo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductController {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductResponseDTO createProduct(@Valid @RequestBody ProductRequestDTO requestDTO){
        Product product = productService.save(productMapper.toEntity(requestDTO));
        return productMapper.toDTO(product);
    }

    @PutMapping("/{productId}")
    public ProductResponseDTO updateProduct(@PathVariable("productId") Long productId,
                                            @Valid @RequestBody ProductRequestDTO requestDTO) throws ResourceNotFoundException {
        Product updateProduct = productService.update(productId, productMapper.toEntity(requestDTO));
        return productMapper.toDTO(updateProduct);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteById(productId);
        return ResponseEntity.ok().build();
    }
}
