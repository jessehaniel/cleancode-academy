package dev.jessehaniel.cleancode.academic.matricula;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
public class Matricula {
    
    @Include
    private String alunoNome;
    @Include
    private String cursoNome;
    private boolean ativa = true;
    private boolean pagamentoEmDia = true;
    
}
