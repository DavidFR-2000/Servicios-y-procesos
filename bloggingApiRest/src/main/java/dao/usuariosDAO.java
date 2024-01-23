package dao;

import dto.usuariosDTO;
import entidades.usuarios;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class usuariosDAO implements usuariosDAOInterface {


    @Override
    public List<usuarios> devolverTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<usuarios> todos = session.createQuery("from usuarios", usuarios.class).list();
        session.close();

        return todos;
    }

    @Override
    public List<usuarios> devolverTodos(int pagina, int objetos_por_pagina) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Consulta HQL con limits
        Query query=session.createQuery("from usuarios", usuarios.class);
        query.setMaxResults(objetos_por_pagina);
        query.setFirstResult((pagina-1)*objetos_por_pagina);
        List<usuarios> todos = query.list();

        session.close();

        return todos;
    }
    @Override
    public List<usuarios> buscarPorNombreLike(String filtroNombre) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<usuarios> query = session.createQuery("from usuarios where nombre like :filtro", usuarios.class);
            query.setParameter("filtro", "%" + filtroNombre + "%");
            return query.list();
        }
    }

    @Override
    public List<usuarios> buscarPorListaParametros(List<String> listaParametros) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Utilizar una consulta HQL con IN para filtrar por la lista de parámetros
            Query<usuarios> query = session.createQuery("from usuarios where nombre IN :listaParametros", usuarios.class);
            query.setParameterList("listaParametros", listaParametros);
            return query.list();
        }
    }

    // Método para realizar una consulta con función de agregación
    @Override
    public Object realizarAgregacion(String tipoAgregacion) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "select " + tipoAgregacion + "(u.fecha) from usuarios u";
            Query query = session.createQuery(hql);

            return query.uniqueResult();
        }
    }

    // Método para buscar usuarios por condición de fecha
    @Override
    public List<usuarios> buscarPorCondicionFecha(String fechaCondicion) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Convertir la cadena de fecha a un objeto Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaCondicionDate = sdf.parse(fechaCondicion);

            // Implementar la lógica para la condición de fecha
            String hql = "from usuarios where fecha > :fechaCondicion";
            Query<usuarios> query = session.createQuery(hql, usuarios.class);
            query.setParameter("fechaCondicion", fechaCondicionDate);

            return query.list();
        } catch (ParseException e) {
            // Manejar la excepción en caso de que la conversión de fecha falle
            e.printStackTrace();
            return null;
        }
    }

    // Método para guardar un nuevo usuario
    @Override
    public void guardarUsuario(usuarios nuevoUsuario) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(nuevoUsuario);
            session.getTransaction().commit();
        }
    }

    // Método para borrar un usuario por ID
    @Override
    public void borrarUsuarioPorId(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            usuarios usuario = session.get(usuarios.class, id);
            if (usuario != null) {
                session.delete(usuario);
            }
            session.getTransaction().commit();
        }
    }

    // Método para actualizar/modificar un usuario
    @Override
    public void actualizarUsuario(usuarios usuarioActualizado) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(usuarioActualizado);
            session.getTransaction().commit();
        }
    }
}
