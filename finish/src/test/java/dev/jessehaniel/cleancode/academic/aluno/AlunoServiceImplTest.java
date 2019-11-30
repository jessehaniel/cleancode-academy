package dev.jessehaniel.cleancode.academic.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import dev.jessehaniel.cleancode.academic.exception.RecursoRepetidoException;
import java.util.Collections;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AlunoServiceImplTest {
    
    private AlunoService service;
    
    @BeforeEach
    void setUp() {
        this.service = new AlunoServiceImpl(new LinkedHashSet<>());
    }
    
    @DisplayName("Cadastro de Aluno com sucesso")
    @Test
    void caminhoFeliz() {
        final Aluno aluno = new Aluno("João", "joao@email.com", false, Collections.emptyList());
        final Aluno alunoCadastrado = this.service.cadastrar(aluno);
        assertNotNull(alunoCadastrado);
        assertEquals(aluno, alunoCadastrado);
    }
    
    @DisplayName("Cadastro duplicado de Aluno, lança exceção RecursoRepetidoException")
    @Test
    void cadastroAlunoDuplicado() {
        final Aluno aluno = new Aluno("João", "joao@email.com", false, Collections.emptyList());
        final Aluno alunoCadastrado = this.service.cadastrar(aluno);
        assertThrows(RecursoRepetidoException.class, () -> this.service.cadastrar(alunoCadastrado));
    }
}