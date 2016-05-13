/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pTitulo2.Neoproyecto;
import pTitulo2.Profesor;

/**
 *
 * @author gerardo
 */
public class ProyectoDao {

    private Session session;
    
    public ProyectoDao(){
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void agregarProyecto(Neoproyecto proyecto) {
        proyecto.setId(getNumProyectos()+1);
        Transaction trans;
        try {
            trans = session.beginTransaction();
            session.save(proyecto);
            trans.commit();
            proyecto.mensajePublicar = true;
        } catch (Exception e) {
        }
    }

    public void editarProyecto(Neoproyecto proyecto) {
        Transaction trans;
        try {
            trans = session.beginTransaction();
            session.update(proyecto);
            trans.commit();
            proyecto.mensajeEditar = true;
        } catch (Exception e) {
        }
    }

    public List<Neoproyecto> getProyectos() {
        List<Neoproyecto> listaProyectos = null;
        try {
            session.beginTransaction();
            Query q = session.createQuery ("from Neoproyecto");
            listaProyectos = (List<Neoproyecto>) q.list();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return listaProyectos;
        
    }
    
        public List<Neoproyecto> getProyectosPorNombre(String nombreProyecto) {
        List<Neoproyecto> listaProyectos = null;
        try {
            session.beginTransaction();
            Query q = session.createQuery ("from Neoproyecto where nombre like '%" + nombreProyecto + "%'");
            listaProyectos = (List<Neoproyecto>) q.list();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return listaProyectos;
        
    }
    
    public List<Neoproyecto> recuperarProyectos() {
        List proyecto = new ArrayList();
        Neoproyecto proyecto1 = new Neoproyecto();
        Transaction trans;
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Neoproyecto");
            proyecto = query.list();
            proyecto.add(proyecto1.getNombre());
            proyecto.add(proyecto1.getProfesor());

            trans.commit();
        } catch (Exception e) {

        }
        return proyecto;
    }

    public List<Neoproyecto> getPorID(int id) {
        List<Neoproyecto> proyectoLista = new ArrayList();
        Neoproyecto proyecto = new Neoproyecto();
        Transaction trans;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Neoproyecto where id= :id");
            query.setInteger("id", id);
            proyecto = (Neoproyecto) query.uniqueResult();
            proyectoLista = query.list();

            trans.commit();
        } catch (Exception e) {
            
        }
        return proyectoLista;
    }

    public void eliminarProyecto(int id) {
        Transaction trans;
        try {
            trans = session.beginTransaction();
            Neoproyecto proyecto = (Neoproyecto) session.load(Neoproyecto.class, id);
            session.delete(proyecto);
            trans.commit();
        } catch (Exception e) {
        }
    }
    
    public List<Neoproyecto> getBusqueda(String aBuscar){
        List<Neoproyecto> listaProyectos = null;
        try {
            session.beginTransaction();
            Query q = session.createQuery ("from Neoproyecto as proyecto where proyecto.nombre like '%"+aBuscar+"%' or "+
                                                                    "proyecto.area_interes like '%"+aBuscar+"%'");
            listaProyectos = (List<Neoproyecto>) q.list();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return listaProyectos;
    }
    
        public static int getNumProyectos() {
        List<Profesor> proyectoLista = new ArrayList();
        int num=0;
        Transaction trans;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("select count(*) from neoproyecto");
            num = (int) query.uniqueResult();
            proyectoLista = query.list();

            trans.commit();
        } catch (Exception e) {
        }
        return num;
    }
}
