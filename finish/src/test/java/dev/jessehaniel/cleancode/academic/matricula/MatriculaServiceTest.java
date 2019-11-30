package dev.jessehaniel.cleancode.academic.matricula;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dev.jessehaniel.cleancode.academic.aluno.Aluno;
import dev.jessehaniel.cleancode.academic.curso.Curso;
import dev.jessehaniel.cleancode.academic.exception.RecursoRepetidoException;
import java.util.LinkedHashSet;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatriculaServiceTest {
    
    private MatriculaService service;
    private LinkedHashSet<Matricula> matriculaSet;
    
    @BeforeEach
    void setUp() {
        this.matriculaSet = new LinkedHashSet<>();
        this.service = new MatriculaServiceImpl(matriculaSet);
    }
    
    @Test
    void matricularCaminhoFeliz() {
        final Aluno aluno = new Aluno();
        aluno.setNome("João");
        final Curso curso = new Curso();
        curso.setNome("Como escrever um código à prova de falhas em Java");
        final Matricula matricula = this.service.matricular(aluno, curso);
        assertNotNull(matricula);
        assertEquals(aluno.getNome(), matricula.getAlunoNome());
        assertEquals(curso.getNome(), matricula.getCursoNome());
    }
    
    @Test
    void matricularRepetido() {
        final Aluno aluno = new Aluno();
        final Curso curso = new Curso();
        this.service.matricular(aluno, curso);
        assertThrows(RecursoRepetidoException.class, () -> this.service.matricular(aluno, curso),
            String.format("Aluno [%s] já matriculado no curso [%s]", aluno.getNome(), curso.getNome()));
    }
    
    @Test
    void findAllByCurso() {
        Curso curso = new Curso();
        curso.setNome("Como escrever um código à prova de falhas em Java");
        final Matricula matricula = Matricula.builder().alunoNome("João")
            .cursoNome(curso.getNome()).build();
        this.matriculaSet.add(matricula);
        final List<Matricula> matriculaList = this.service.findAllByCurso(curso);
        assertTrue(matriculaList.stream().map(Matricula::getAlunoNome).anyMatch("João"::equals));
    }
    
    @Test
    void findAllByAluno() {
        final Aluno aluno = new Aluno();
        aluno.setNome("João");
        final Matricula matricula = Matricula.builder().alunoNome(aluno.getNome())
            .cursoNome("Como escrever um código à prova de falhas em Java").build();
        this.matriculaSet.add(matricula);
        final List<Matricula> matriculaList = this.service.findAllByAluno(aluno);
        assertTrue(matriculaList.stream().map(Matricula::getCursoNome)
            .anyMatch(("Como escrever um código à prova de falhas em Java")::equals));
    }
}
