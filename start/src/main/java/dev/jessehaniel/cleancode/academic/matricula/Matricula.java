package dev.jessehaniel.cleancode.academic.matricula;

import java.util.Objects;

public class Matricula {
    
    private String alunoNome;
    private String cursoNome;
    private boolean ativa = true;
    private boolean pagamentoEmDia = true;
    
    public Matricula() {
    }
    
    public Matricula(String alunoNome, String cursoNome, boolean ativa, boolean pagamentoEmDia) {
        this.alunoNome = alunoNome;
        this.cursoNome = cursoNome;
        this.ativa = ativa;
        this.pagamentoEmDia = pagamentoEmDia;
    }
    
    public String getAlunoNome() {
        return alunoNome;
    }
    
    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }
    
    public String getCursoNome() {
        return cursoNome;
    }
    
    public void setCursoNome(String cursoNome) {
        this.cursoNome = cursoNome;
    }
    
    public boolean isAtiva() {
        return ativa;
    }
    
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
    
    public boolean isPagamentoEmDia() {
        return pagamentoEmDia;
    }
    
    public void setPagamentoEmDia(boolean pagamentoEmDia) {
        this.pagamentoEmDia = pagamentoEmDia;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Matricula matricula = (Matricula) o;
        return alunoNome.equals(matricula.alunoNome) &&
            cursoNome.equals(matricula.cursoNome);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(alunoNome, cursoNome);
    }
}
