package io.guidemy.learn.productwishlistdemo.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductResponseDTO {
    private Long id;

    private  String title;

    private String description;

    private BigDecimal price;

    private String thumbnail;

    private boolean addedToWishlist;
}
