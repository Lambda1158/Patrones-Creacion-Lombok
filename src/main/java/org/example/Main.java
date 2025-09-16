package org.example;
import org.example.singleton.Database;
import org.example.factory.*;
import org.example.abstractFactory.*;
import org.example.builder.Usuario;
import org.example.prototype.*;
import java.util.Date;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
                System.out.println("=== PATRONES CREACIONALES - BIBLIOTECA ONLINE ===\n");

                // 1. Singleton
                System.out.println("1. SINGLETON");
                Database db1 = Database.getInstance();
                Database db2 = Database.getInstance();
                System.out.println("Misma instancia? " + (db1 == db2));

                // 2. Factory Method
                System.out.println("\n2. FACTORY METHOD");
                org.example.factory.Libro libro1 = LogisticaLibro.crearLibro("fisico", "Cien años de soledad", "García Márquez");
                org.example.factory.Libro libro2 = LogisticaLibro.crearLibro("digital", "1984", "George Orwell");

                System.out.println(libro1);
                System.out.println(libro2);

                // 3. Abstract Factory
                System.out.println("\n3. ABSTRACT FACTORY");
                Abstractfactory adminFactory = FabricaProvider.getFactory("admin");
                Abstractfactory userFactory = FabricaProvider.getFactory("usuario");

                InterfazUI adminUI = adminFactory.crearInterfaz();
                MetodoEnvio adminEnvio = adminFactory.crearMetodoEnvio();
                System.out.println("Admin: " + adminUI.getTipo() + " - " + adminEnvio.getTipo());

                InterfazUI userUI = userFactory.crearInterfaz();
                MetodoEnvio userEnvio = userFactory.crearMetodoEnvio();
                System.out.println("Usuario: " + userUI.getTipo() + " - " + userEnvio.getTipo());

                // 4. Builder
                System.out.println("\n4. BUILDER");
                Usuario usuario1 = Usuario.builder()
                        .nombre("Maria Garcia")
                        .email("maria@gmail.com")
                        .direccion("Calle 123")
                        .telefono("123456789")
                        .build();

                Usuario usuario2 =  Usuario.builder()
                        .nombre("Rocio Avena")
                        .email("rocioavena@gmail.com")
                        .fechaNacimiento(new Date())
                        .build();

                System.out.println(usuario1);
                System.out.println(usuario2);

                // 5. Prototype
                System.out.println("\n5. PROTOTYPE");
                org.example.prototype.Libro libro = org.example.prototype.Libro.builder().autor("Cervantes").titulo("El Quijote").build();
                org.example.prototype.Usuario user = org.example.prototype.Usuario.builder().nombre("Carlos Perez").build();
                Prestamo prestamoOriginal = Prestamo.builder()
                        .libro(libro)
                        .usuario(user)
                        .fechaInicio(new Date())
                        .fechaFin(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000))
                        .build();


                Prestamo prestamoClon1 = prestamoOriginal.clone();
                Prestamo prestamoClon2 = prestamoOriginal.clone();

                System.out.println("Original: " + prestamoOriginal);
                System.out.println("Clon 1: " + prestamoClon1);
                System.out.println("Clon 2: " + prestamoClon2);
                System.out.println("Mismo objeto? " + (prestamoOriginal == prestamoClon1));
    }
}