package io.guidemy.learn.productwishlistdemo.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpResponseDTO {
    private String firebaseUID;
}
