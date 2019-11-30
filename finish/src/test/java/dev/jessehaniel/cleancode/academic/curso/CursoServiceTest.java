package dev.jessehaniel.cleancode.academic.curso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import dev.jessehaniel.cleancode.academic.exception.NaoEncontradoException;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

class CursoServiceTest {
    
    private CursoRepository repository;
    private CursoService service;
    
    @BeforeEach
    void setUp() {
        this.repository = mock(CursoRepository.class);
        this.service = new CursoServiceImpl(repository);
    }
    
    @Test
    void caminhoFeliz() {
        final Curso curso = new Curso();
        curso.setNome("Como escrever um código à prova de falhas em Java");
        when(this.repository.findFirstByNome(ArgumentMatchers.anyString())).thenReturn(Optional.of(curso));
        
        final Curso cursoEncontrado = this.service.findOneByNome(curso.getNome());
        assertNotNull(cursoEncontrado);
        assertEquals(curso.getNome(), cursoEncontrado.getNome());
    }
    
    @Test
    void naoEncontrado() {
        when(repository.findFirstByNome(anyString())).thenThrow(NaoEncontradoException.class);
        assertThrows(NaoEncontradoException.class, () -> this.service.findOneByNome("não existe"));
    }
}
