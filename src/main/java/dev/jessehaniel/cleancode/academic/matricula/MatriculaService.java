package dev.jessehaniel.cleancode.academic.matricula;

import dev.jessehaniel.cleancode.academic.aluno.Aluno;
import dev.jessehaniel.cleancode.academic.curso.Curso;

public interface MatriculaService {
    
    boolean matricula(Aluno aluno, Curso curso);
}
