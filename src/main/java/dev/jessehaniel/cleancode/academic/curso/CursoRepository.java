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
    
    private List<Curso> cursoList = new ArrayList<Curso>();
    
    public CursoRepository() {
        init();
    }
    
    public List<Curso> findAll() {
        return this.cursoList;
    }
    
    private void init() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:cursos.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
                curso.setNome(split[0]);
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
