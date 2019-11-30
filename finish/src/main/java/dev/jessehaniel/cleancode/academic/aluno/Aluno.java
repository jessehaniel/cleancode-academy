package dev.jessehaniel.cleancode.academic.aluno;

import dev.jessehaniel.cleancode.academic.matricula.Matricula;
import java.util.List;

/**
 * @author jessehaniel Esta classe não foi alvo de Clean Code
 */
public class Aluno {
    
    private String nome;
    private String email;
    private boolean inadimplente;
    private List<Matricula> matriculaList;
    
    public Aluno() {
    }
    
    public Aluno(String nome, String email, boolean inadimplente,
        List<Matricula> matriculaList) {
        this.nome = nome;
        this.email = email;
        this.inadimplente = inadimplente;
        this.matriculaList = matriculaList;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public boolean isInadimplente() {
        return inadimplente;
    }
    
    public void setInadimplente(boolean inadimplente) {
        this.inadimplente = inadimplente;
    }
    
    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }
    
    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }
}
