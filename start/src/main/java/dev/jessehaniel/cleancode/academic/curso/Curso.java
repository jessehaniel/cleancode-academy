package dev.jessehaniel.cleancode.academic.curso;

import java.util.Objects;

public class Curso {
    
    private String nome;
    private String instrutorNome;
    private Integer qtdVagas;
    
    public Curso() {
    }
    
    public Curso(String nome, String instrutorNome, Integer qtdVagas) {
        this.nome = nome;
        this.instrutorNome = instrutorNome;
        this.qtdVagas = qtdVagas;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getInstrutorNome() {
        return instrutorNome;
    }
    
    public void setInstrutorNome(String instrutorNome) {
        this.instrutorNome = instrutorNome;
    }
    
    public Integer getQtdVagas() {
        return qtdVagas;
    }
    
    public void setQtdVagas(Integer qtdVagas) {
        this.qtdVagas = qtdVagas;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Curso curso = (Curso) o;
        return Objects.equals(nome, curso.nome) &&
            Objects.equals(instrutorNome, curso.instrutorNome) &&
            Objects.equals(qtdVagas, curso.qtdVagas);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nome, instrutorNome, qtdVagas);
    }
    
    @Override
    public String toString() {
        return "Curso{" +
            "nome='" + nome + '\'' +
            ", instrutorNome='" + instrutorNome + '\'' +
            ", qtdVagas=" + qtdVagas +
            '}';
    }
}
