package dev.jessehaniel.cleancode.academic.matricula;

import dev.jessehaniel.cleancode.academic.aluno.Aluno;
import dev.jessehaniel.cleancode.academic.curso.Curso;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MatriculaServiceImpl implements MatriculaService {
    
    private Set<Matricula> matriculaSet = new LinkedHashSet<>();
    
    @Override
    public boolean matricular(Aluno aluno, Curso curso) {
        final Matricula matricula = Matricula.builder()
            .alunoNome(aluno.getNome())
            .cursoNome(curso.getNome())
            .build();
        return matriculaSet.add(matricula);
    }
    
    @Override
    public List<Matricula> findAllByCurso(Curso curso) {
        return matriculaSet.stream()
            .filter(matricula -> curso.getNome().equals(matricula.getCursoNome()))
            .collect(Collectors.toList());
    }
    
    @Override
    public List<Matricula> findAllByAluno(Aluno aluno) {
        return matriculaSet.stream()
            .filter(matricula -> aluno.getNome().equals(matricula.getAlunoNome()))
            .collect(Collectors.toList());
    }
}
