package dev.jessehaniel.cleancode.academic.matricula;

import dev.jessehaniel.cleancode.academic.aluno.Aluno;
import dev.jessehaniel.cleancode.academic.curso.Curso;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatriculaServiceImpl implements MatriculaService {
    
    private List<Matricula> matriculaList = new ArrayList<>();
    
    @Override
    public boolean matricula(Aluno aluno, Curso curso) {
        Matricula matricula = new Matricula();
        matricula.setAlunoNome(aluno.getNome());
        matricula.setCursoNome(curso.getNome());
        
        if (!matriculaList.contains(matricula) && !aluno.isInadimplente()) {
            matriculaList.add(matricula);
            return true;
        }
        
        return false;
    }
    
    @Override
    public List<Matricula> findAllByCurso(Curso curso) {
        return matriculaList.stream().filter(matricula -> curso.getNome().equals(matricula.getCursoNome())).collect(
            Collectors.toList());
    }
    
    @Override
    public List<Matricula> findAllByAluno(Aluno aluno) {
        return matriculaList.stream().filter(matricula -> aluno.getNome().equals(matricula.getAlunoNome())).collect(
            Collectors.toList());
    }
}
