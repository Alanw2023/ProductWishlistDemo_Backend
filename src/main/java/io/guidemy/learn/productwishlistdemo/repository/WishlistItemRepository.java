package io.guidemy.learn.productwishlistdemo.repository;

import io.guidemy.learn.productwishlistdemo.model.Product;
import io.guidemy.learn.productwishlistdemo.model.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WishlistItemRepository extends JpaRepository<WishlistItem,Long> {
    @Query("SELECT wli.product FROM WishlistItem wli " +
            "WHERE wli.firebaseUID = :firebaseUID order by createdAt DESC")
    List<Product> findAllProductsByFirebaseUID(String firebaseUID);
    @Modifying
    @Query("DELETE FROM WishlistItem wli WHERE wli.product.id = :productId")
    void deleteByProductId(@Param("productId")Long productId);

    boolean existsByProduct(Product product);
}
