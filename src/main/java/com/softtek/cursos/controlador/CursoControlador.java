package com.softtek.cursos.controlador;

import com.softtek.cursos.modelo.Curso;
import com.softtek.cursos.servicio.ICursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @ RestController: Indic que esta clase es un controlador REST que manejará las solicitudes HTTP


/*@RequestMapping especifica la ruta base para todas las solicitudes a este controlador,
que en este caso es /cursos.*/

/*@CrossOrigin permite el acceso a este controlador desde un origen externo,
en este caso, desde http://localhost:4200, útil para realizar solicitudes desde Angular*/
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/")
public class CursoControlador {
    //Inyección instancia de la interfaz ICursoServicio
    @Autowired
    ICursoServicio servicio;

    /*obtenerCurso() se ejecutará cuando se realice una solicitud GET a la ruta /cursos.*/
    @GetMapping("/cursos")
    public Curso obtenerCurso() {

        // Llamas y retornas al método obtenerUno del servicio pasando el objeto Paciente
        return servicio.obtenerCurso(1);
    }
}
