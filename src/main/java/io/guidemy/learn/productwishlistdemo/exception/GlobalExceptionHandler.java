package io.guidemy.learn.productwishlistdemo.exception;

import io.guidemy.learn.productwishlistdemo.dto.response.ApiResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiResponseDTO<String> handleResourceNotFoundException(ResourceNotFoundException ex){
        return ApiResponseDTO.error(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponseDTO<String> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        return ApiResponseDTO.error(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedOperationException.class)
    public ApiResponseDTO<String> handlerUnauthorizedOperationException(UnauthorizedOperationException ex){
        return ApiResponseDTO.error(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ApiResponseDTO<String> handleUnknownException(Exception ex){
        return ApiResponseDTO.error(ex.getMessage());
    }
}
