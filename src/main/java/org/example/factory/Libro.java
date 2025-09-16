package org.example.factory;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public interface Libro {
    String getTipo();
    String getTitulo();
    String getAutor();
}


@Builder
@ToString
class LibroFisico implements Libro {
    private String titulo;
    private String autor;


    @Override
    public String getTipo() { return "Físico"; }

    @Override
    public String getTitulo() { return titulo; }

    @Override
    public String getAutor() { return autor; }
}

@ToString
@Builder
class LibroDigital implements Libro {
    private String titulo;
    private String autor;

    @Override
    public String getTipo() { return "Digital"; }

    @Override
    public String getTitulo() { return titulo; }

    @Override
    public String getAutor() { return autor; }

}