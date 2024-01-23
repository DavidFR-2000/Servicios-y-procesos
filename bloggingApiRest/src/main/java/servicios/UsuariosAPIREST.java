package servicios;

import com.google.gson.Gson;
import dao.usuariosDAOInterface;
import entidades.usuarios;
import spark.Spark;

import java.util.Arrays;
import java.util.List;

public class UsuariosAPIREST {
    private usuariosDAOInterface dao;
    private Gson gson = new Gson();

    public UsuariosAPIREST(usuariosDAOInterface implementacion){
        Spark.port(8080);
        dao = implementacion;

        //Endpoint Obtener todos los usuarios
        Spark.get("/usuarios", ((request, response) -> {
            List<usuarios> usuarios = dao.devolverTodos();
            response.type("aplication/json");
            return gson.toJson(usuarios);
        }));
        // Listar todos los usuarios que cumplan un filtro tipo LIKE en el nombre
        Spark.get("/usuarios/filtro-like", (request, response) -> {
            String filtroNombre = request.queryParams("filtroNombre");
            List<usuarios> usuarios = dao.buscarPorNombreLike(filtroNombre);
            response.type("application/json");
            return gson.toJson(usuarios);
        });

        Spark.get("/usuarios/filtro-in", (request, response) -> {
            // Obtener la lista de parámetros de la solicitud
            String[] valores = request.queryParamsValues("listaParametros");

            // Verificar si se proporcionaron valores para el filtro IN
            if (valores != null && valores.length > 0) {
                // Llamar al método de tu DAO que realiza la consulta con filtro IN
                List<usuarios> usuariosFiltrados = dao.buscarPorListaParametros(Arrays.asList(valores));

                // Devolver la lista de usuarios que cumplen con el filtro IN
                response.type("application/json");
                return gson.toJson(usuariosFiltrados);
            } else {
                // Manejar el caso en que no se proporcionaron valores para el filtro IN
                response.status(400); // Bad Request
                return "Debes proporcionar al menos un valor para el filtro IN.";
            }
        });

        // Consulta que use una función de agregación (avg, count, min, max, etc)
        Spark.get("/usuarios/agregacion", (request, response) -> {
            String tipoAgregacion = request.queryParams("tipoAgregacion");
            Object resultadoAgregacion = dao.realizarAgregacion(tipoAgregacion);
            response.type("application/json");
            return gson.toJson(resultadoAgregacion);
        });

        // Listar los usuarios que cumplan una determinada condición (por ejemplo, fecha después de cierta fecha)
        Spark.get("/usuarios/condicion", (request, response) -> {
            String fechaCondicion = request.queryParams("fechaCondicion");
            List<usuarios> usuarios = dao.buscarPorCondicionFecha(fechaCondicion);
            response.type("application/json");
            return gson.toJson(usuarios);
        });

        // Crear nuevo usuario (hacerlo de manera transaccional)
        Spark.post("/usuarios", (request, response) -> {
            usuarios nuevoUsuario = gson.fromJson(request.body(), usuarios.class);
            dao.guardarUsuario(nuevoUsuario);
            response.status(201);
            return "Usuario creado correctamente";
        });

        // Borrar un usuario a partir del ID (hacerlo de manera transaccional)
        Spark.delete("/usuarios/:id", (request, response) -> {
            Long id = Long.parseLong(request.params(":id"));
            dao.borrarUsuarioPorId(id);
            response.status(204);
            return "Usuario eliminado correctamente";
        });

        // Actualizar/modificar un usuario a partir del ID (hacerlo de manera transaccional)
        Spark.put("/usuarios/:id", (request, response) -> {
            Long id = Long.parseLong(request.params(":id"));
            usuarios usuarioActualizado = gson.fromJson(request.body(), usuarios.class);
            usuarioActualizado.setId(id);
            dao.actualizarUsuario(usuarioActualizado);
            response.status(200);
            return "Usuario actualizado correctamente";
        });
    }

}
