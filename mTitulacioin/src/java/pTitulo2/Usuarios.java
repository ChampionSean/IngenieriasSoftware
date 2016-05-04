package pTitulo2;
// Generated May 4, 2016 2:55:33 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Usuarios generated by hbm2java
 */
@Entity
@Table(name="usuarios"
    ,schema="public"
)
public class Usuarios  implements java.io.Serializable {


     private int id;
     private String password;
     private Profesor profesor;
     private Admin admin;
     private Estudiante estudiante;

    public Usuarios() {
    }

	
    public Usuarios(int id) {
        this.id = id;
    }
    public Usuarios(int id, String password, Profesor profesor, Admin admin, Estudiante estudiante) {
       this.id = id;
       this.password = password;
       this.profesor = profesor;
       this.admin = admin;
       this.estudiante = estudiante;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="password")
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="usuarios")
    public Profesor getProfesor() {
        return this.profesor;
    }
    
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="usuarios")
    public Admin getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="usuarios")
    public Estudiante getEstudiante() {
        return this.estudiante;
    }
    
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }




}


