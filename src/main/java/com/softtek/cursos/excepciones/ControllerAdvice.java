package com.softtek.cursos.excepciones;

import com.softtek.cursos.excepciones.CursoFoundException;
import com.softtek.cursos.excepciones.ErrorDTO;
import com.softtek.cursos.excepciones.CursoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//Esta clase encarga de capturar las excepciones de controlador de tipo runTime o las que nosotros definamos
public class ControllerAdvice {
    /*Anotación para se utiliza para manejar excepciones específicas en un controlador
    o en una clase de asesoramiento de controladores (@ControllerAdvice).*/
    @ExceptionHandler(value = CursoNotFoundException.class)
    //Definimos el método
    public ResponseEntity<ErrorDTO> runtimeExceptionHandler(CursoNotFoundException ex) {
        ErrorDTO error = new ErrorDTO();
        error.setCode("cursoNotFound");
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = CursoFoundException.class)
    //Definimos el método
    public ResponseEntity<ErrorDTO> runtimeExceptionHandler(CursoFoundException ex2) {
        ErrorDTO error = new ErrorDTO();
        error.setCode("cursoFound");
        error.setMessage(ex2.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = CursosNotFoundException.class)
    public ResponseEntity<ErrorDTO> runtimeExceptionHandler(CursosNotFoundException ex3){
        ErrorDTO error = new ErrorDTO();
        error.setCode("Error 500");
        error.setMessage(ex3.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }




}
