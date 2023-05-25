package com.softtek.cursos.repositorio;

import com.softtek.cursos.modelo.Curso;

import java.util.List;

public interface ICursoRepo {
    Curso obtenerCurso(int c1);
    Curso crearCurso(Curso curso);
    Curso actualizarCurso(Curso curso);
    Curso eliminarCurso(int c1);
    List<Curso> obtenerTodosCursos();
}
