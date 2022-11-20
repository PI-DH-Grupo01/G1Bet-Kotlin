package br.com.g1bet.exceptions;

public class EmailExistenteException extends RuntimeException {

    public EmailExistenteException(String message) {
        super(message);
    }

}
