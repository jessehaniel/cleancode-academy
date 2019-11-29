package dev.jessehaniel.cleancode.academic.curso;

import dev.jessehaniel.cleancode.academic.exception.NaoEncontradoException;

public class CursoServiceImpl implements CursoService {
    
    private CursoRepository repository;
    
    public CursoServiceImpl() {
        this.repository = new CursoRepository();
    }
    
    @Override
    public Curso findOneByNome(String cursoNome) {
        return repository.findFirstByNome(cursoNome)
            .orElseThrow(() -> new NaoEncontradoException(String.format("Curso %s não encontrado", cursoNome)));
    }
}