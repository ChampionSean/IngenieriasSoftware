package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pTitulo.Admin;
import pTitulo.Estudiante;
import util.HibernateUtil;
import pTitulo.Profesor;

/**
 *
 * @author miguel
 */
public class LoginDao {

    private Session session;

    public LoginDao() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Estudiante getLoginEstudiante(int cuenta) {
        Estudiante resultado=null;
        try {
            session.beginTransaction();
            //Query q = session.getNamedQuery("BuscaPorNombre").setString("usuario", nombre);
            Query q = session.createQuery ("from Estudiante as estudiante where estudiante.noCuenta = "+cuenta);
            resultado = (Estudiante) q.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return resultado;
    }
    
    public Profesor getLoginProfesor(int cuenta) {
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Profesor as profesor where profesor.id = "+cuenta);
            tx.commit();
            return (Profesor) q.uniqueResult();
        } catch (Exception e) {
        }
        return null;
    }
    public Admin getLoginAdmin(int cuenta) {
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Admin as admin where admin.id = " + cuenta);
            tx.commit();
            return (Admin) q.uniqueResult();
        } catch (Exception e) {
        }
        return null;
    }
}