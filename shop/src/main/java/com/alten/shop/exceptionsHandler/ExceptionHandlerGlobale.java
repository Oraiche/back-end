package com.alten.shop.exceptionsHandler;

import com.alten.shop.exceptions.ProduitNonTrouve;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerGlobale {

   @ExceptionHandler(ProduitNonTrouve.class)
    public ResponseEntity<String> handleSocieteNotFoundException(ProduitNonTrouve ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
