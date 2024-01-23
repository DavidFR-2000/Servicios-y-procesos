package dao;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import servicios.UsuariosAPIREST;

import java.util.Arrays;
import java.util.List;

public class UsuariosDAOTest {
    static usuariosDAOInterface dao;

    @BeforeAll
    static void setUp(){
        dao=new usuariosDAO();
    }

    @AfterAll
    static void setDown(){
        //     dao.deleteAll();
    }

    @Test
    void devolverTodos() {
        System.out.println(dao.devolverTodos());


    }

}