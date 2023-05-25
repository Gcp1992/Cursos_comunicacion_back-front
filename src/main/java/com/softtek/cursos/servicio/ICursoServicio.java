package com.softtek.cursos.servicio;

import com.softtek.cursos.modelo.Curso;

import java.util.List;

public interface ICursoServicio {
    Curso obtenerCurso(int c1);
    Curso agregarCurso(Curso curso);
    Curso actualizarCurso(Curso curso);
    Curso eliminarCurso(int c1);
    List<Curso> obtenerTodos();
}
