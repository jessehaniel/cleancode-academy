package dev.jessehaniel.cleancode.academic.exception;

public class NaoEncontradoException extends RuntimeException {
    
    public NaoEncontradoException(String message) {
        super(message);
    }
}
