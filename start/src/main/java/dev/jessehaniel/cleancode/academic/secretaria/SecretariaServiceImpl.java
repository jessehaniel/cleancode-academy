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
            sendEmail(aluno.getEmail(),
                "Boleto do mês " + LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault())
                    + "/" + LocalDate.now().getYear(),
                "Prezado " + aluno.getNome() + ", informamos que o seu boleto deste mês já está disponível.");
        }
    }
    
    private void dispararMalaDireta(Aluno aluno) {
        sendEmail(aluno.getEmail(), "assunto", "texto");
    }
    
    @Override
    public void sendEmail(String email, String subject, String text) {
        //TODO Implementar envio real de email
        System.out.println(
            String.format("De: %s\nPara: %s\nAssunto: %s\nMensagem: %s", "CleanCode", email, subject, text));
    }
}
