/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pTitulo2.Profesor;
import pTitulo2.Usuarios;

/**
 *
 * @author gerardo
 */
public class ProfesorDao {
    private Session session;
    public ProfesorDao(){
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void agregarProfesor(Profesor proyecto) {
        Transaction trans;
        try {
            trans = session.beginTransaction();
            session.save(new Usuarios(proyecto.getNoCuenta()));
            proyecto.setUsuarios(new Usuarios(proyecto.getNoCuenta()));
            session.save(proyecto);
            trans.commit();
        } catch (Exception e) {
        }
    }

    public void editarProyecto(Profesor proyecto) {
        Transaction trans;
        try {
            trans = session.beginTransaction();
            session.update(proyecto);
            trans.commit();
        } catch (Exception e) {
        }
    }

    public List<Profesor> recuperarProyectos() {

        List proyecto = new ArrayList();
        Profesor proyecto1 = new Profesor();
        Transaction trans;
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Proyecto");
            proyecto = query.list();
            proyecto.add(proyecto1.getNombre());
            //proyecto.add(proyecto1.getProfesor());

            trans.commit();
        } catch (Exception e) {

        }
        return proyecto;
    }

    public List<Profesor> getPorID(BigDecimal id) {
        List<Profesor> proyectoLista = new ArrayList();
        Profesor proyecto = new Profesor();
        Transaction trans;
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Proyecto where id= :id");
            query.setBigDecimal("id", id);
            proyecto = (Profesor) query.uniqueResult();
            proyectoLista = query.list();

            trans.commit();
        } catch (Exception e) {
        }
        return proyectoLista;
    }

    public void eliminarProyecto(BigDecimal id) {
        Transaction trans;
        try {
            trans = session.beginTransaction();
            Profesor proyecto = (Profesor) session.load(Profesor.class, id);
            session.delete(proyecto);
            trans.commit();
        } catch (Exception e) {
        }
    }
    
    public static int getNumProfesores() {
        List<Profesor> proyectoLista = new ArrayList();
        int num=0;
        Transaction trans;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("select count(*) from Profesor");
            num = (int) query.uniqueResult();
            proyectoLista = query.list();

            trans.commit();
        } catch (Exception e) {
        }
        return num;
    }
}
