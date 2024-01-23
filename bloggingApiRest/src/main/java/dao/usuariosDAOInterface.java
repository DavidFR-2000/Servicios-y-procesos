package dao;

import dto.usuariosDTO;
import entidades.usuarios;

import java.util.List;

public interface usuariosDAOInterface {

    List<usuarios> devolverTodos();

    List<usuarios> devolverTodos(int pagina, int tamanio);

    List<usuarios> buscarPorNombreLike(String filtroNombre);
    List<usuarios> buscarPorListaParametros(List<String> listaParametros);

    Object realizarAgregacion(String tipoAgregacion);

    List<usuarios> buscarPorCondicionFecha(String fechaCondicion);

    void guardarUsuario(usuarios nuevoUsuario);

    void borrarUsuarioPorId(Long id);

    void actualizarUsuario(usuarios usuarioActualizado);
}
