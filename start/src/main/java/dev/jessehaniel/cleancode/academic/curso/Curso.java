package dev.jessehaniel.cleancode.academic.curso;

import java.util.Objects;

public class Curso {
    
    private String cursoNome;
    private String instrutorNome;
    private Integer qtdVagas;
    
    public Curso() {
    }
    
    public Curso(String cursoNome, String instrutorNome, Integer qtdVagas) {
        this.cursoNome = cursoNome;
        this.instrutorNome = instrutorNome;
        this.qtdVagas = qtdVagas;
    }
    
    public String getCursoNome() {
        return cursoNome;
    }
    
    public void setCursoNome(String cursoNome) {
        this.cursoNome = cursoNome;
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
        return Objects.equals(cursoNome, curso.cursoNome) &&
            Objects.equals(instrutorNome, curso.instrutorNome) &&
            Objects.equals(qtdVagas, curso.qtdVagas);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(cursoNome, instrutorNome, qtdVagas);
    }
    
    @Override
    public String toString() {
        return "Curso{" +
            "nome='" + cursoNome + '\'' +
            ", instrutorNome='" + instrutorNome + '\'' +
            ", qtdVagas=" + qtdVagas +
            '}';
    }
}
