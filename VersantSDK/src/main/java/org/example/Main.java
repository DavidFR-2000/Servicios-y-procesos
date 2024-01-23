package org.example;
import com.actian.odb.api.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // **Crear una fábrica de conexiones**
        ConnectionFactory factory = new ConnectionFactory();

        // **Crear una conexión**
        Connection connection = factory.createConnection("localhost", 11000, "admin", "password");

        // **Crear un objeto para almacenar en la base de datos**
        Persona persona = new Persona();
        persona.setId(1);
        persona.setNombre("Juan Pérez");
        persona.setEdad(30);

        // **Guardar el objeto en la base de datos**
        connection.save(persona);

        // **Cerrar la conexión**
        connection.close();

        // **Leer el objeto de la base de datos**
        Persona personaLeida = connection.find(persona.getId());

        // **Imprimir el objeto**
        System.out.println(personaLeida);

        // **Actualizar el objeto en la base de datos**
        personaLeida.setNombre("María López");
        connection.update(personaLeida);

        // **Eliminar el objeto de la base de datos**
        connection.delete(personaLeida);
    }
}