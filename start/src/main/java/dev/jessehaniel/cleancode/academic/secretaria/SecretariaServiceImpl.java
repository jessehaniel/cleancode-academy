package dev.jessehaniel.cleancode.academic.secretaria;

import dev.jessehaniel.cleancode.academic.aluno.Aluno;
import dev.jessehaniel.cleancode.academic.curso.Curso;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class SecretariaServiceImpl implements SecretariaService {
    
    @Override
    public List<Certificado> emitirCertificadosList(Aluno aluno) {
        return null;
    }
    
    @Override
    public List<Certificado> emitirCertificadosList(Curso curso) {
        return null;
    }
    
    @Override
    public Certificado emitirCertificado(Aluno aluno, Curso curso) {
        return null;
    }
    
    @Override
    public void dispararMalaDireta(List<Aluno> alunoList) {
        for (Aluno aluno : alunoList) {
            if (!aluno.isInadimplente()) {
                dispararMalaDireta(aluno);
            }
        }
    }
    
    @Override
    public void emitirCobranca(List<Aluno> alunoList) {
        for (Aluno aluno : alunoList) {
            sendEmail(aluno.getNome(), aluno.getEmail(),
                "Boleto do mês " + LocalDate.now().getMonth().getDisplayName(TextStyle.SHORT, Locale.getDefault()),
                "Prezado aluno, informamos que o boleto deste mês já está disponível");
        }
    }
    
    private void dispararMalaDireta(Aluno aluno) {
        sendEmail(aluno.getNome(), aluno.getEmail(), "assunto", "texto");
    }
    
    private void sendEmail(String dest, String email, String subject, String text) {
        //TODO
    }
}
