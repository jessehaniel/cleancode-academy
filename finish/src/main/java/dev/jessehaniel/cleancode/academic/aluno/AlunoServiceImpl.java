package dev.jessehaniel.cleancode.academic.aluno;

import dev.jessehaniel.cleancode.academic.exception.RecursoRepetidoException;
import java.util.Set;

public class AlunoServiceImpl implements AlunoService {
    
    private Set<Aluno> alunoSet;
    
    public AlunoServiceImpl(Set<Aluno> alunoSet) {
        this.alunoSet = alunoSet;
    }
    
    @Override
    public Aluno cadastrar(Aluno aluno) {
        if (alunoSet.add(aluno)) {
            return aluno;
        } else {
            throw new RecursoRepetidoException("Aluno já cadastrado");
        }
    }
    
}
