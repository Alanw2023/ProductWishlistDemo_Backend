package io.guidemy.learn.productwishlistdemo.controller;

import com.google.firebase.auth.FirebaseAuthException;
import io.guidemy.learn.productwishlistdemo.dto.request.SignUpRequestDTO;
import io.guidemy.learn.productwishlistdemo.dto.response.SignUpResponseDTO;
import io.guidemy.learn.productwishlistdemo.exception.UnauthorizedOperationException;
import io.guidemy.learn.productwishlistdemo.firebase.FirebaseAuthService;
import io.guidemy.learn.productwishlistdemo.model.Role;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/signup")
public class SignupController {
    @Autowired
   private FirebaseAuthService firebaseAuthService;

    @Value("${admin.secret.code}")
    private String adminSecretCode;

    @PostMapping("/user")
    public SignUpResponseDTO signUser(@Valid @RequestBody SignUpRequestDTO requestDTO) throws FirebaseAuthException{
        String firebaseUID = firebaseAuthService.getFirebaseUID(requestDTO);
        firebaseAuthService.setUserClaims(firebaseUID, List.of(Role.USER));
        return SignUpResponseDTO.builder()
                .firebaseUID(firebaseUID)
                .build();
    }
    @PostMapping("/admin")
    public SignUpResponseDTO signAdmin(@Valid @RequestBody SignUpRequestDTO requestDTO) throws FirebaseAuthException, UnauthorizedOperationException {
        if (!adminSecretCode.equals(requestDTO.getSecretCode())){
            throw new UnauthorizedOperationException("Invalid admin secret code");
        }
        String firebaseUID = firebaseAuthService.getFirebaseUID(requestDTO);
        firebaseAuthService.setUserClaims(firebaseUID, List.of(Role.USER,Role.ADMIN));
        return SignUpResponseDTO.builder()
                .firebaseUID(firebaseUID)
                .build();
    }
}
