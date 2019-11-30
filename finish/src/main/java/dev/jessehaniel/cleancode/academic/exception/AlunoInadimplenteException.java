package dev.jessehaniel.cleancode.academic.exception;

/**
 * @author jessehaniel Unchecked Exceptions (exceções que herdam de RuntimeException) permitem um código mais fluído
 * sendo opcional sua captura no momento mais oportuno para o tratamento
 */
public class AlunoInadimplenteException extends RuntimeException {
    
    public AlunoInadimplenteException(String message) {
        super(message);
    }
}
