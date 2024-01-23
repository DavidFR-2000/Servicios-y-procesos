import dao.usuariosDAO;
import servicios.UsuariosAPIREST;

public class Servidor {

    public static void main(String[] args){
        UsuariosAPIREST api = new UsuariosAPIREST(new usuariosDAO());
    }
}
