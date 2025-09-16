package org.example.builder;

import java.util.Date;
import lombok.*;

import lombok.Builder;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
public class Usuario {
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    private Date fechaNacimiento;
}