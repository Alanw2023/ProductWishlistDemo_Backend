package io.guidemy.learn.productwishlistdemo.exception;

public class UnauthorizedOperationException extends Exception{
    public UnauthorizedOperationException(String message){
        super(message);
    }
}
