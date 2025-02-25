package dio.java.rest_api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import dio.java.rest_api.exceptions.ProductNullException;
import dio.java.rest_api.exceptions.ProductPriceException;

@ControllerAdvice
public class ProdutoControllerAdvice extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(ProductNullException.class)
    public ResponseEntity<Object> capturaErroNull(){

        Map<String, Object> body = new HashMap<>();
        body.put("Message: ", "Verifique os campos do produto");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ProductPriceException.class)
    public ResponseEntity<Object> capturaErroPreco(){

        Map<String, Object> body = new HashMap<>();
        body.put("Message:", "O preço não pode ser menor que zero");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
