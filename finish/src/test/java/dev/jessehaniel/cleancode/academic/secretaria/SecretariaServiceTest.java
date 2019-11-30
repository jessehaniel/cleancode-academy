package dev.jessehaniel.cleancode.academic.secretaria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import dev.jessehaniel.cleancode.academic.aluno.Aluno;
import dev.jessehaniel.cleancode.academic.curso.Curso;
import dev.jessehaniel.cleancode.academic.curso.CursoService;
import dev.jessehaniel.cleancode.academic.matricula.Matricula;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SecretariaServiceTest {
    
    private CursoService cursoService;
    private SecretariaService service;
    
    @BeforeEach
    void setUp() {
        this.cursoService = Mockito.mock(CursoService.class);
        this.service = new SecretariaServiceImpl(cursoService);
    }
    
    @Test
    void emitirCertificadosList() {
        final Aluno aluno = new Aluno();
        final Curso curso = new Curso();
        curso.setNome("Como escrever um código à prova de falhas em Java");
        final Matricula matricula = Matricula.builder().alunoNome(aluno.getNome())
            .cursoNome(curso.getNome()).build();
        aluno.setMatriculaList(Collections.singletonList(matricula));
        
        when(this.cursoService.findOneByNome(anyString())).thenReturn(curso);
        
        final List<Certificado> certificados = this.service.emitirCertificadosList(aluno);
        assertFalse(certificados.isEmpty());
        assertTrue(certificados.stream().map(Certificado::getDataConclusao).anyMatch(LocalDate.now()::equals));
    }
    
    @Test
    void emitirCertificado() {
        final Aluno aluno = new Aluno();
        aluno.setNome("João");
        final Curso curso = new Curso();
        curso.setNome("Como escrever um código à prova de falhas em Java");
    
        final Certificado certificado = this.service.emitirCertificado(aluno, curso);
        assertEquals(LocalDate.now(), certificado.getDataConclusao());
    }
    
}
