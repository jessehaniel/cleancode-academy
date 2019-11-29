package dev.jessehaniel.cleancode.academic.curso;

import dev.jessehaniel.cleancode.academic.exception.RepositoryException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.jetbrains.annotations.NotNull;

@Slf4j
public class CursoRepository {
    
    private List<Curso> cursoList;
    
    public CursoRepository() {
        loadCursosFromFile();
    }
    
    public Collection<Curso> findAll() {
        return CollectionUtils.emptyIfNull(this.cursoList);
    }
    
    public Optional<Curso> findFirstByNome(@NotNull String cursoNome) {
        return this.cursoList.stream().filter(curso -> cursoNome.equals(curso.getNome())).findFirst();
    }
    
    private void loadCursosFromFile() {
        try (Stream<String> stream = Files.lines(Paths.get("classpath:cursos.csv"))) {
            this.cursoList = stream.map(this::getCursoFromStringCsv)
                .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RepositoryException("Erro durante a leitura do arquivo de Cursos", e);
        }
    }
    
    private Curso getCursoFromStringCsv(String line) {
        final String[] split = line.split(",");
        final Curso curso = new Curso();
        curso.setNome(split[0]);
        curso.setInstrutorNome(split[1]);
        curso.setQtdVagas(Integer.valueOf(split[2]));
        return curso;
    }
    
}
