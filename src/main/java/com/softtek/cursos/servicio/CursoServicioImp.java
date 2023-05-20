package com.softtek.cursos.servicio;

import com.softtek.cursos.modelo.Curso;
import com.softtek.cursos.repositorio.ICursoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServicioImp implements ICursoServicio{
    @Autowired
    ICursoRepo repo;
    @Override
    public Curso obtenerCurso(int c1) {
        return repo.obtenerCurso(c1);
    }
}
