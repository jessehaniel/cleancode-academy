package dev.jessehaniel.cleancode.academic.curso;

import lombok.Data;

/**
 * @author jessehaniel Classe refatorada com lombok diminuindo o código escrito e facilitando a manutenção
 */
@Data
public class Curso {
    
    private String nome;
    private String instrutorNome;
    private Integer qtdVagas;
}
