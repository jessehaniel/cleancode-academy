package dev.jessehaniel.cleancode.academic.curso;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CursoRepositoryTest {
    
    private CursoRepository repository;
    
    @BeforeEach
    void setUp() {
        this.repository = new CursoRepository();
    }
    
    @Test
    void findAll() {
        //cenário
        final String nome = "Como escrever um código à prova de falhas em Java";
        //ação
        final List<Curso> cursoList = repository.findAll();
        //validação
        assertTrue(cursoList.stream().anyMatch(curso -> nome.equals(curso.getCursoNome())));
    }
}