package io.guidemy.learn.productwishlistdemo.service;

import io.guidemy.learn.productwishlistdemo.model.Product;
import io.guidemy.learn.productwishlistdemo.model.WishlistItem;
import io.guidemy.learn.productwishlistdemo.repository.WishlistItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistItemService {
    @Autowired
    private WishlistItemRepository wishlistItemRepository;
    public boolean existsByProduct(Product product) {
        return wishlistItemRepository.existsByProduct(product);
    }
    public List<Product> findAllProductsByFirebaseUID(String firebaseUID) {
        return wishlistItemRepository.findAllProductsByFirebaseUID(firebaseUID);
    }
    @Transactional
    public WishlistItem addWishlistItem(WishlistItem wishlistItem) {
        return wishlistItemRepository.save(wishlistItem);
    }
    @Transactional
    public void removeWishlistItemByProductId(Long productId) {
        wishlistItemRepository.deleteByProductId(productId);
    }
}
