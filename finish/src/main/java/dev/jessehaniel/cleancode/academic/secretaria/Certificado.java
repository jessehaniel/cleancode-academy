package dev.jessehaniel.cleancode.academic.secretaria;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Certificado {
    
    private String alunoNome;
    private String cursoNome;
    private LocalDate dataConclusao = LocalDate.now();
    
    public Certificado(String alunoNome, String cursoNome) {
        this.alunoNome = alunoNome;
        this.cursoNome = cursoNome;
    }
    
}
