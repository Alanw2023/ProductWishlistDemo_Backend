package io.guidemy.learn.productwishlistdemo.repository;

import io.guidemy.learn.productwishlistdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
