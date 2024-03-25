package com.ellenteste.demo.exception;

import com.ellenteste.demo.exception.exceptions.LotacaoComNomeJaExistenteException;
import com.ellenteste.demo.exception.exceptions.LotacaoNaoExisteException;
import com.ellenteste.demo.exception.exceptions.ServidorNaoExisteException;
import com.ellenteste.demo.exception.exceptions.dto.DefaultError;
import com.ellenteste.demo.exception.exceptions.LotacaoPossuiServidoresException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionhandler {

    @ExceptionHandler(LotacaoPossuiServidoresException.class)
    public ResponseEntity handleLotacaoPossuiServidoresException(LotacaoPossuiServidoresException ex){
        DefaultError error = new DefaultError(HttpStatus.CONFLICT.value(), ex.getMessage());
        return new ResponseEntity(error, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(LotacaoNaoExisteException.class)
    public ResponseEntity handleLotacaoPossuiServidoresException(LotacaoNaoExisteException ex){
        DefaultError error = new DefaultError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ServidorNaoExisteException.class)
    public ResponseEntity handleServidorNaoExisteException(ServidorNaoExisteException ex){
        DefaultError error = new DefaultError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LotacaoComNomeJaExistenteException.class)
    public ResponseEntity handleLotacaoComNomeJaExistenteException(LotacaoComNomeJaExistenteException ex){
        DefaultError error = new DefaultError(HttpStatus.CONFLICT.value(), ex.getMessage());
        return new ResponseEntity(error, HttpStatus.CONFLICT);
    }

}
