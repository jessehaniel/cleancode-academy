package dev.jessehaniel.cleancode.academic.matricula;

import dev.jessehaniel.cleancode.academic.aluno.Aluno;
import dev.jessehaniel.cleancode.academic.curso.Curso;
import dev.jessehaniel.cleancode.academic.exception.AlunoInadimplenteException;
import dev.jessehaniel.cleancode.academic.exception.RecursoRepetidoException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author jessehaniel Refatoração usando coleção Set ao invés de List, é a escolha correta para evitar elementos
 * repetidos. Também a lista é iniciada via construtor, permitindo ser iniciada apenas no momento oportuno.
 */
public class MatriculaServiceImpl implements MatriculaService {
    
    private Set<Matricula> matriculaSet;
    
    public MatriculaServiceImpl(Set<Matricula> matriculaSet) {
        this.matriculaSet = matriculaSet;
    }
    
    @Override
    public Matricula matricular(Aluno aluno, Curso curso) {
        validarAlunoInadimplente(aluno);
        final Matricula matricula = getMatriculaFor(aluno, curso);
        return realizarMatricula(aluno, curso, matricula);
    }
    
    private Matricula realizarMatricula(Aluno aluno, Curso curso, Matricula matricula) {
        if (matriculaSet.add(matricula)) {
            return matricula;
        } else {
            throw new RecursoRepetidoException(String.format("Aluno [%s] já matriculado no curso [%s]",
                aluno.getNome(), curso.getNome()));
        }
    }
    
    private Matricula getMatriculaFor(Aluno aluno, Curso curso) {
        return Matricula.builder()
            .alunoNome(aluno.getNome())
            .cursoNome(curso.getNome())
            .build();
    }
    
    private void validarAlunoInadimplente(Aluno aluno) {
        if (aluno.isInadimplente()) {
            throw new AlunoInadimplenteException("Aluno inadimplente. Não é possível realizar nova matrícula.");
        }
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
