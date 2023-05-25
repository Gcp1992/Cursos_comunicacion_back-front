package com.softtek.cursos.servicio;

import com.softtek.cursos.modelo.Curso;
import com.softtek.cursos.repositorio.ICursoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServicioImp implements ICursoServicio {
    private ICursoRepo repo;

    @Autowired
    public CursoServicioImp(ICursoRepo repo) {
        this.repo = repo;
    }

    @Override
    public Curso obtenerCurso(int c1) {
        return repo.obtenerCurso(c1);
    }

    @Override
    public Curso agregarCurso(Curso curso) {
        return repo.crearCurso(curso);
    }

    @Override
    public Curso actualizarCurso(Curso curso) {
        return repo.actualizarCurso(curso);
    }

    @Override
    public Curso eliminarCurso(int c1) {
        return repo.eliminarCurso(c1);
    }

    @Override
    public List<Curso> obtenerTodos() {
        return repo.obtenerTodosCursos();
    }
}
