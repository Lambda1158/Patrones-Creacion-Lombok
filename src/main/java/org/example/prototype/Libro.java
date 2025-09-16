package org.example.prototype;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Builder
public class Libro {
    private String titulo;
    private String autor;
}