package io.guidemy.learn.productwishlistdemo.mapper;

import io.guidemy.learn.productwishlistdemo.dto.request.WishlistItemRequestDTO;
import io.guidemy.learn.productwishlistdemo.exception.ResourceNotFoundException;
import io.guidemy.learn.productwishlistdemo.model.WishlistItem;
import io.guidemy.learn.productwishlistdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WishlistItemMapper {
    @Autowired
    private ProductService productService;
    public WishlistItem toEntity(WishlistItemRequestDTO requestDTO,
                                 String firebaseUID) throws ResourceNotFoundException {
        return WishlistItem.builder()
                .product(productService.findById(requestDTO.getProductID()))
                .firebaseUID(firebaseUID)
                .build();
    }
}
