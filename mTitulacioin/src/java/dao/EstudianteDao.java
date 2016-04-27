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
import pTitulo.Estudiante;

/**
 *
 * @author gerardo
 */
public class EstudianteDao {

    static int aux = 1;
    private Session session;
    public EstudianteDao(){
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void agregarEstudiante(Estudiante proyecto) {
        Transaction trans;
        try {
            trans = session.beginTransaction();
            session.save(proyecto);
            trans.commit();
        } catch (Exception e) {
        }
        aux++;
    }

    public void editarProyecto(Estudiante proyecto) {
        Transaction trans;
        try {
            trans = session.beginTransaction();
            session.update(proyecto);
            trans.commit();
        } catch (Exception e) {
        }
    }

    public List<Estudiante> recuperarProyectos() {

        List proyecto = new ArrayList();
        Estudiante proyecto1 = new Estudiante();
        Transaction trans;
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Proyecto");
            proyecto = query.list();
            proyecto.add(proyecto1.getNombre());
            proyecto.add(proyecto1.getProfesor());

            trans.commit();
        } catch (Exception e) {
        }
        return proyecto;
    }

    public List<Estudiante> getPorID(BigDecimal id) {
        List<Estudiante> proyectoLista = new ArrayList();
        Estudiante proyecto = new Estudiante();
        Transaction trans;
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Proyecto where id= :id");
            query.setBigDecimal("id", id);
            proyecto = (Estudiante) query.uniqueResult();
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
            Estudiante proyecto = (Estudiante) session.load(Estudiante.class, id);
            session.delete(proyecto);
            trans.commit();
        } catch (Exception e) {
        }
    }

}
