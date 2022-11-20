package br.com.g1bet.handler;

import br.com.g1bet.exceptions.EmailExistenteException;
import br.com.g1bet.exceptions.CampoNullException;
import br.com.g1bet.exceptions.SaldoInsuficienteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handlerEmailExisteException(EmailExistenteException emailExistenteException) {
        return ResponseEntity.badRequest().body(emailExistenteException.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handlerSenhaNullException(CampoNullException senhaNullException) {
        return ResponseEntity.badRequest().body(senhaNullException.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handlerSaldoInsuficienteException(SaldoInsuficienteException saldoInsuficienteException) {
        return ResponseEntity.badRequest().body(saldoInsuficienteException.getMessage());
    }

}
