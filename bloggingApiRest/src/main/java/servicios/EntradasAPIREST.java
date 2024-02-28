package servicios;

import com.google.gson.Gson;
import dao.entradasDAOInterface;
import dao.usuariosDAOInterface;
import entidades.entradas;
import spark.Spark;

import java.util.List;

public class EntradasAPIREST {

    private entradasDAOInterface dao;
    private Gson gson = new Gson();

    public EntradasAPIREST(entradasDAOInterface implementacion){
        Spark.port(8080);
        dao = implementacion;

        Spark.get("/entradas", (((request, response) -> {
            List<entradas> entradas = dao.devolverTodos();
            response.type("aplication/json");
            return gson.toJson(entradas);
        })));
    }
}
