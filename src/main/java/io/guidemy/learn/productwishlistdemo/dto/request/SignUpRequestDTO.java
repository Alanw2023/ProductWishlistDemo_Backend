package io.guidemy.learn.productwishlistdemo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignUpRequestDTO {
    @NotBlank
    private String displayName;
    @Email
    private  String email;
    @NotBlank
    private String password;
    private String secretCode;
}
