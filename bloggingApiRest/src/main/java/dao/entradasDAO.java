package dao;

import entidades.entradas;
import entidades.usuarios;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class entradasDAO implements entradasDAOInterface{


    @Override
    public List<entradas> devolverTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<entradas> todos = session.createQuery("from entradas", entradas.class).list();
        session.close();

        return todos;
    }
}
