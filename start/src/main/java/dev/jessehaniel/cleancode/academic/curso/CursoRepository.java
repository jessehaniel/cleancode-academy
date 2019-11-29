package dev.jessehaniel.cleancode.academic.curso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.ResourceUtils;

public class CursoRepository {
    
    private static final String CLASSPATH_CURSOS_CSV = "classpath:cursos.csv";
    private List<Curso> cursoList = new ArrayList<>();
    
    public CursoRepository() {
        carregarCursos();
    }
    
    public List<Curso> findAll() {
        return this.cursoList;
    }
    
    private void carregarCursos() {
        File file = null;
        try {
            file = ResourceUtils.getFile(CLASSPATH_CURSOS_CSV);
        } catch (FileNotFoundException e) {
            //log
        }
        if (file == null) {
            return;
        }
        
        try (FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                final String[] split = line.split(",");
                final Curso curso = new Curso();
                curso.setCursoNome(split[0]);
                curso.setInstrutorNome(split[1]);
                curso.setQtdVagas(Integer.valueOf(split[2]));
                this.cursoList.add(curso);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
