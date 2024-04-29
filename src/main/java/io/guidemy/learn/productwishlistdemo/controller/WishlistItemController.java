package io.guidemy.learn.productwishlistdemo.controller;

import io.guidemy.learn.productwishlistdemo.dto.request.WishlistItemRequestDTO;
import io.guidemy.learn.productwishlistdemo.dto.response.ProductResponseDTO;
import io.guidemy.learn.productwishlistdemo.exception.ResourceNotFoundException;
import io.guidemy.learn.productwishlistdemo.mapper.ProductMapper;
import io.guidemy.learn.productwishlistdemo.mapper.WishlistItemMapper;
import io.guidemy.learn.productwishlistdemo.model.WishlistItem;
import io.guidemy.learn.productwishlistdemo.service.WishlistItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/wishlist-items")
public class WishlistItemController {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private WishlistItemMapper wishlistItemMapper;

    @Autowired
    private WishlistItemService wishlistItemService;

    @GetMapping
    public List<ProductResponseDTO> findAllWishlistItemsByUser(Principal principal){
        return wishlistItemService.findAllProductsByFirebaseUID(principal.getName()).stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Void> addWishListItem(@RequestBody WishlistItemRequestDTO requestDTO,
                                                Principal principal) throws ResourceNotFoundException {
        WishlistItem wishlistItem = wishlistItemMapper.toEntity(requestDTO, principal.getName());
        wishlistItemService.addWishlistItem(wishlistItem);
        return ResponseEntity.ok().build();

    }
        @DeleteMapping
        public ResponseEntity<Void> removeWishlistItem(@RequestBody WishlistItemRequestDTO requestDTO){
            wishlistItemService.removeWishlistItemByProductId(requestDTO.getProductID());
            return ResponseEntity.ok().build();
        }
    }

