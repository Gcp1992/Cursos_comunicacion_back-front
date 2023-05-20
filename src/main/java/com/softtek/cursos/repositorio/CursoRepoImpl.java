package com.softtek.cursos.repositorio;

import com.softtek.cursos.modelo.Curso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class CursoRepoImpl implements ICursoRepo{
    ArrayList<Curso> cursos = new ArrayList<>();

    public CursoRepoImpl() {
        cursos.add(new Curso(1, "Ingeniería de Sistemas", 2019,3));

    }
    public Curso obtenerCurso(int c1) {
        for (Curso c : cursos) {
            if (c.getIdCurso() == c1) {
                return c;
            }
        }
        return null;
    }
}
