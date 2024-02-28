import dao.entradasDAO;
import dao.usuariosDAO;
import servicios.EntradasAPIREST;
import servicios.UsuariosAPIREST;
import servicios.blogAPIREST;

public class Servidor {

    public static void main(String[] args){
        blogAPIREST api = new blogAPIREST(new usuariosDAO());
        blogAPIREST api2 = new blogAPIREST(new entradasDAO());

    }
}
