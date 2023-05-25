package com.softtek.cursos.controlador;

import com.softtek.cursos.excepciones.CursoFoundException;
import com.softtek.cursos.excepciones.CursoNotFoundException;
import com.softtek.cursos.modelo.Curso;
import com.softtek.cursos.servicio.ICursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.FOUND)
    public Curso obtenerCurso(@PathVariable("id") int id) {
        if(id <= 0 || id > servicio.obtenerTodos().size()){
            throw new CursoNotFoundException("Id del curso no encontrado");
        }
        // Llamas y retornas al método obtenerUno del servicio pasando el objeto Paciente
        return servicio.obtenerCurso(id);
    }

    /*agregarCurso() se ejecutará cuando se realice una solicitud POST a la ruta /cursos.*/
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso agregarCurso(@RequestBody Curso curso) {
        /*Controlamos a través de una excepción la id del curso que queremos agregar con las id's
        * existentes de los cursos que ya tenemos. Si la id del curso que quiero agregar ya existe,
        * lanzamos la excepción*/
        List<Curso> cursos = servicio.obtenerTodos();
        for (Curso c : cursos) {
            if (c.getIdCurso() == curso.getIdCurso()) {
                throw new CursoFoundException("El curso ya existe");
            }
        }

        return servicio.agregarCurso(curso);
    }

    /*actualizarCurso() se ejecutará cuando se realice una solicitud PUT a la ruta /cursos.*/
    @PutMapping
    public Curso actualizarCurso(@RequestBody Curso curso) {
        if(curso.getIdCurso() <= 0 || curso.getIdCurso() > servicio.obtenerTodos().size()){
            throw new CursoNotFoundException("Id del curso no encontrado");
        }
        return servicio.actualizarCurso(curso);
    }

    /*eliminarCurso() se ejecutará cuando se realice una solicitud DELETE a la ruta /cursos.*/
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarCurso(@PathVariable("id") int id) {
        if(id <= 0 || id > servicio.obtenerTodos().size()){
            throw new CursoNotFoundException("Id del curso no encontrado");
        }
        servicio.eliminarCurso(id);
    }

    /*obtenerTodos() se ejecutará cuando se realice una solicitud GET a la ruta /cursos.*/
    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public Iterable<Curso> obtenerTodos() {
        Iterable<Curso> cursos = servicio.obtenerTodos();
        if(cursos == null){
            //Error 500
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener todos los cursos");
        }
        return cursos;
    }

}
