package io.guidemy.learn.productwishlistdemo.dto.request;

import com.google.firebase.database.annotations.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductRequestDTO {
    @NotBlank
    private String title;
    @NotBlank
    private  String description;

    @NotNull
    private BigDecimal price;

    private String thumbnail;
}
