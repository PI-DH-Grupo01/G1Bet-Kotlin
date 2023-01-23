package br.com.g1bet.handler

import br.com.g1bet.mapper.exceptions.CampoExistenteException
import br.com.g1bet.mapper.exceptions.CampoNullException
import br.com.g1bet.mapper.exceptions.IdNaoExisteException
import br.com.g1bet.mapper.exceptions.SaldoInsuficienteException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class CustomExceptionHandler {
    @ExceptionHandler
    fun handlerEmailExisteException(emailExistenteException: CampoExistenteException): ResponseEntity<String?> {
        return ResponseEntity.badRequest().body(emailExistenteException.message)
    }

    @ExceptionHandler
    fun handlerSenhaNullException(senhaNullException: CampoNullException): ResponseEntity<String?> {
        return ResponseEntity.badRequest().body(senhaNullException.message)
    }

    @ExceptionHandler
    fun handlerSaldoInsuficienteException(saldoInsuficienteException: SaldoInsuficienteException): ResponseEntity<String?> {
        return ResponseEntity.badRequest().body(saldoInsuficienteException.message)
    }

    @ExceptionHandler
    fun handlerIdNaoExisteException(idNaoExisteException: IdNaoExisteException): ResponseEntity<String?> {
        return ResponseEntity.badRequest().body(idNaoExisteException.message)
    }
}