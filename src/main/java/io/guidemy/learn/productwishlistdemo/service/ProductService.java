package io.guidemy.learn.productwishlistdemo.service;

import io.guidemy.learn.productwishlistdemo.exception.ResourceNotFoundException;
import io.guidemy.learn.productwishlistdemo.model.Product;
import io.guidemy.learn.productwishlistdemo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long productId) throws ResourceNotFoundException {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Product not found by id " + productId
                ));
    }
    @Transactional
    public Product save(Product product){
        return productRepository.save(product);
    }

    @Transactional
    public void deleteById(Long productId){
        productRepository.deleteById(productId);
    }

    @Transactional
    public Product update(Long productId, Product product) throws ResourceNotFoundException{
        Product existingProduct = findById(productId);

        existingProduct.setTitle(product.getTitle());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setThumbnail(product.getThumbnail());

        return productRepository.save(existingProduct);
    }
}
