package com.softtek.cursos.excepciones;

public class CursosNotFoundException extends RuntimeException {
    public CursosNotFoundException(String message) {
        super(message);
    }
}
