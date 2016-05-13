package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pTitulo2.Admin;
import pTitulo2.Estudiante;
import util.HibernateUtil;
import pTitulo2.Profesor;

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
        Profesor resultado=null;
        try {
            session.beginTransaction();
            Query q = session.createQuery ("from Profesor as profesor where profesor.noCuenta = "+cuenta);
            resultado = (Profesor) q.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return resultado;
    }
    public Admin getLoginAdmin(int cuenta) {
        Admin  resultado=null;
        try {
            session.beginTransaction();
            Query q = session.createQuery ("from Admin as admin where admin.id = " + cuenta);
            resultado = (Admin) q.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return resultado;
    }
}