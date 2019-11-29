package dev.jessehaniel.cleancode.academic.secretaria;

import dev.jessehaniel.cleancode.academic.aluno.Aluno;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SecretariaServiceImplTest {
    
    private SecretariaService service;
    
    @BeforeEach
    void setUp() {
        this.service = new SecretariaServiceImpl();
    }
    
    @Test
    void emitirCobranca() {
        //cenário
        final Aluno aluno = new Aluno();
        aluno.setNome("João");
        aluno.setEmail("joao@email.com");
        final List<Aluno> alunoList = Collections.singletonList(aluno);
        //ação
        this.service.emitirCobranca(alunoList);
    }
}