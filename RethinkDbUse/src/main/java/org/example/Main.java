package org.example;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;
import com.rethinkdb.net.Result;

import java.awt.*;


public class Main {
    public static void main(String[] args) {
        final RethinkDB r = RethinkDB.r;
        //Creamos la conexion a RethinkDB
        Connection conn = r.connection().hostname("localhost").port(28015).connect();

        //Creamos una tabla
        r.db("test").tableCreate("Juegos").run(conn);
        //Agregamos datos a la tabla
        r.table("Juegos").insert(r.array(
                r.hashMap("nombre", "Kingdom Hearts")
                        .with("Aventura", "Mundos disney")
                        .with("Saga", r.array(
                                        r.hashMap("KH I", "El inicio")
                                                .with("Contenido", "Empieza la aventura de sora"),
                                        r.hashMap("Kh II", "Roxas")
                                                .with("Contenido", "Continuacion kh I"),
                                        r.hashMap("Kh III", "La guerra de las llave espada")
                                                .with("Contenido", "Lucha contra xenahort")
                                )
                        )
        )).run(conn);

        //Pedimos que nos de los datos
        Result<Object> cursor = r.table("Juegos").run(conn);
        for (Object doc : cursor){
            System.out.println(doc);
        }
    }
}