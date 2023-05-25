package com.softtek.cursos.controlador;

import com.softtek.cursos.excepciones.CursoFoundException;
import com.softtek.cursos.excepciones.CursoNotFoundException;
import com.softtek.cursos.excepciones.CursosNotFoundException;
import com.softtek.cursos.modelo.Curso;
import com.softtek.cursos.servicio.ICursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

// @ RestController: Indic que esta clase es un controlador REST que manejará las solicitudes HTTP
@RestController
/*@CrossOrigin permite el acceso a este controlador desde un origen externo,
en este caso, desde http://localhost:4200, útil para realizar solicitudes desde Angular*/
@CrossOrigin("http://localhost:4200")
/*@RequestMapping especifica la ruta base para todas las solicitudes a este controlador,
que en este caso es /cursos.*/
@RequestMapping("/cursos")
public class CursoControlador {
    //Inyección instancia de la interfaz ICursoServicio
    @Autowired
    ICursoServicio servicio;

    /*obtenerCurso() se ejecutará cuando se realice una solicitud GET a la ruta /cursos.*/
    @GetMapping("/{id}")
    /*ResponseEntity es una clase en el framework Spring que representa una respuesta HTTP
    enviada desde un controlador*/
    public ResponseEntity<Curso> obtenerCurso(@PathVariable("id") int id) {
        if (id <= 0 || id > servicio.obtenerTodos().size()) {
            throw new CursoNotFoundException("Id del curso no encontrado");
        }
        Curso curso = servicio.obtenerCurso(id);
        return ResponseEntity.ok(curso);
    }

    /*agregarCurso() se ejecutará cuando se realice una solicitud POST a la ruta /cursos.*/
    @PostMapping
    public ResponseEntity<Curso> agregarCurso(@RequestBody Curso curso) {
        List<Curso> cursos = servicio.obtenerTodos();
        for (Curso c : cursos) {
            if (c.getIdCurso() == curso.getIdCurso()) {
                throw new CursoFoundException("El curso ya existe");
            }
        }
        Curso nuevoCurso = servicio.agregarCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCurso);
    }


    /*actualizarCurso() se ejecutará cuando se realice una solicitud PUT a la ruta /cursos.*/
    @PutMapping
    public ResponseEntity<Curso> actualizarCurso(@RequestBody Curso curso) {
        if (curso.getIdCurso() <= 0 || curso.getIdCurso() > servicio.obtenerTodos().size()) {
            throw new CursoNotFoundException("Id del curso no encontrado");
        }
        Curso cursoActualizado = servicio.actualizarCurso(curso);
        return ResponseEntity.ok(cursoActualizado);
    }


    /*eliminarCurso() se ejecutará cuando se realice una solicitud DELETE a la ruta /cursos.*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> eliminarCurso(@PathVariable("id") int id) {
        if (id <= 0 || id > servicio.obtenerTodos().size()) {
            throw new CursoNotFoundException("Id del curso no encontrado");
        }
        Curso cursoEliminado = servicio.eliminarCurso(id);
        return ResponseEntity.ok(cursoEliminado);
    }


    /*obtenerTodos() se ejecutará cuando se realice una solicitud GET a la ruta /cursos.*/
    @GetMapping
    public ResponseEntity<Iterable<Curso>> obtenerTodos() {
        Iterable<Curso> cursos = servicio.obtenerTodos();
        if (cursos == null) {
            throw new CursosNotFoundException("No hay cursos");
        }
        return ResponseEntity.ok(cursos);
    }

}
