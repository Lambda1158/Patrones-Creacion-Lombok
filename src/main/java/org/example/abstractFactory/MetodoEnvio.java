package org.example.abstractFactory;

public interface MetodoEnvio {
    void enviarNotificacion(String mensaje);
    String getTipo();
}