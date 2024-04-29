package io.guidemy.learn.productwishlistdemo.mapper;

import io.guidemy.learn.productwishlistdemo.dto.request.ProductRequestDTO;
import io.guidemy.learn.productwishlistdemo.dto.response.ProductResponseDTO;
import io.guidemy.learn.productwishlistdemo.model.Product;
import io.guidemy.learn.productwishlistdemo.service.WishlistItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    @Autowired
    private WishlistItemService wishlistItemService;
    public Product toEntity(ProductRequestDTO productRequestDTO){
        return Product.builder()
                .title(productRequestDTO.getTitle())
                .description(productRequestDTO.getDescription())
                .price(productRequestDTO.getPrice())
                .thumbnail(productRequestDTO.getThumbnail())
                .build();
    }

    public ProductResponseDTO toDTO(Product product){
        return ProductResponseDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .thumbnail(product.getThumbnail())
                .addedToWishlist(wishlistItemService.existsByProduct(product))
                .build();
    }
}
