package org.example.prototype;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
public class Prestamo implements Cloneable {
    private Libro libro;
    private Usuario usuario;
    private Date fechaInicio;
    private Date fechaFin;


    @Override
    public Prestamo clone() {
        try {
            // Shallow copy (las fechas se comparten, pero son inmutables)
            return (Prestamo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}