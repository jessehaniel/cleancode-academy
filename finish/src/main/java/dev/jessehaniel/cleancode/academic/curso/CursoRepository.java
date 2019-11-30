package dev.jessehaniel.cleancode.academic.curso;

import dev.jessehaniel.cleancode.academic.exception.RepositoryException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.collections4.CollectionUtils;
import org.jetbrains.annotations.NotNull;

/**
 * @author jessehaniel
 *
 * Código refatorado segundo o Single Responsability (SOLID). Cada método faz apenas 1 coisa.
 */
public class CursoRepository {
    
    private List<Curso> cursoList;
    
    public CursoRepository() {
        loadCursosFromResourceFile();
    }
    
    public Collection<Curso> findAll() {
        return CollectionUtils.emptyIfNull(this.cursoList);
    }
    
    public Optional<Curso> findFirstByNome(@NotNull String cursoNome) {
        return this.cursoList.stream().filter(curso -> cursoNome.equals(curso.getNome())).findFirst();
    }
    
    private void loadCursosFromResourceFile() {
        try (Stream<String> stream = Files.lines(getCsvPath())) {
            convertInputLineToCursoList(stream);
        } catch (IOException e) {
            throw new RepositoryException("Erro durante a leitura do arquivo de Cursos", e);
        }
    }
    
    private void convertInputLineToCursoList(Stream<String> stream) {
        this.cursoList = stream.map(this::getCursoFromStringCsv)
            .collect(Collectors.toList());
    }
    
    @NotNull
    private Path getCsvPath() {
        return Paths.get("src/main/resources/cursos.csv");
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
