package com.softtek.cursos.repositorio;

import com.softtek.cursos.modelo.Curso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepoImpl implements ICursoRepo {
    private ArrayList<Curso> cursos = new ArrayList<>();

    public CursoRepoImpl() {
        this.cursos.add(new Curso(1, "Ingeniería de Sistemas", 60, 3));
    }

    @Override
    public Curso obtenerCurso(int c1) {
        for (Curso c : cursos) {
            if (c.getIdCurso() == c1) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Curso crearCurso(Curso c) {
        cursos.add(c);
        return c;
    }

    @Override
    public Curso actualizarCurso(Curso c) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getIdCurso() == c.getIdCurso()) {
                cursos.set(i, c);
                return c;
            }
        }
        return null;
    }

    @Override
    public Curso eliminarCurso(int c1) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getIdCurso() == c1) {
                return cursos.remove(i);
            }
        }
        return null;
    }

    @Override
    public List<Curso> obtenerTodosCursos() {
        return cursos;
    }
}
