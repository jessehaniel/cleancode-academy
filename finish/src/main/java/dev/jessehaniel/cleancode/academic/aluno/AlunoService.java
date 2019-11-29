package dev.jessehaniel.cleancode.academic.aluno;

public interface AlunoService {
    
    Aluno cadastrar(Aluno aluno);
    
    void pagarMatriculasAtivas(Aluno aluno);
}
