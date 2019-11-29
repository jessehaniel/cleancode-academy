package dev.jessehaniel.cleancode.academic.matricula;

import dev.jessehaniel.cleancode.academic.aluno.Aluno;
import dev.jessehaniel.cleancode.academic.curso.Curso;
import java.util.List;

public interface MatriculaService {
    
    boolean matricula(Aluno aluno, Curso curso);
    
    List<Matricula> findAllByCurso(Curso curso);
    
    List<Matricula> findAllByAluno(Aluno aluno);
}
