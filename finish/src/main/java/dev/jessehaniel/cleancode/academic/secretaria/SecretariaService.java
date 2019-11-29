package dev.jessehaniel.cleancode.academic.secretaria;

import dev.jessehaniel.cleancode.academic.aluno.Aluno;
import dev.jessehaniel.cleancode.academic.curso.Curso;
import java.util.List;

public interface SecretariaService {
    
    List<Certificado> emitirCertificadosList(Aluno aluno);
    
    List<Certificado> emitirCertificadosList(Curso curso);
    
    Certificado emitirCertificado(Aluno aluno, Curso curso);
    
    void dispararMalaDireta(List<Aluno> alunoList);
    
    void emitirCobranca(List<Aluno> alunoList);
}
