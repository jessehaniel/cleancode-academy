package dev.jessehaniel.cleancode.academic.secretaria;

import dev.jessehaniel.cleancode.academic.aluno.Aluno;
import dev.jessehaniel.cleancode.academic.curso.Curso;
import dev.jessehaniel.cleancode.academic.curso.CursoService;
import dev.jessehaniel.cleancode.academic.exception.AlunoInadimplenteException;
import dev.jessehaniel.cleancode.academic.matricula.Matricula;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class SecretariaServiceImpl implements SecretariaService {
    
    private CursoService cursoService;
    
    public SecretariaServiceImpl(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    
    @Override
    public List<Certificado> emitirCertificadosList(Aluno aluno) {
        return aluno.getMatriculaList().stream()
            .map(Matricula::getCursoNome)
            .map(this.cursoService::findOneByNome)
            .map(curso -> this.emitirCertificado(aluno, curso))
            .collect(Collectors.toList());
    }
    
    @Override
    public List<Certificado> emitirCertificadosList(Curso curso) {
        //TODO lógica semelhante a emitirCertificadosList(Aluno aluno)
        return Collections.emptyList();
    }
    
    @Override
    public Certificado emitirCertificado(Aluno aluno, Curso curso) {
        validarAlunoInadimplente(aluno);
        return new Certificado(aluno.getNome(), curso.getNome());
    }
    
    private void validarAlunoInadimplente(Aluno aluno) {
        if (aluno.isInadimplente()) {
            throw new AlunoInadimplenteException("Aluno inadimplente. Não é possível emitir o Certificado.");
        }
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
