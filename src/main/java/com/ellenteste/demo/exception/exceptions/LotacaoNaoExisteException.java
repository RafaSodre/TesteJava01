package com.ellenteste.demo.exception.exceptions;

public class LotacaoNaoExisteException extends RuntimeException{
    public LotacaoNaoExisteException(String message) {
        super(message);
    }
}
