package com.ellenteste.demo.exception.exceptions;

public class ServidorNaoExisteException extends RuntimeException{
    public ServidorNaoExisteException(String message) {
        super(message);
    }
}
