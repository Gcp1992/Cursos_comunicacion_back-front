package com.softtek.cursos.modelo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    private int idCurso;
    private String nombre;
    private int duracion;
    private int idProfesor;
}


