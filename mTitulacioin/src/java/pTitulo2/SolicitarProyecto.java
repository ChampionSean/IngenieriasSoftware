package pTitulo2;
// Generated May 4, 2016 2:55:33 PM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SolicitarProyecto generated by hbm2java
 */
@Entity
@Table(name="solicitar_proyecto"
    ,schema="public"
)
public class SolicitarProyecto  implements java.io.Serializable {


     private SolicitarProyectoId id;
     private Estudiante estudiante;
     private String justificacion;
     private String fechaSolicitud;

    public SolicitarProyecto() {
    }

	
    public SolicitarProyecto(SolicitarProyectoId id, Estudiante estudiante) {
        this.id = id;
        this.estudiante = estudiante;
    }
    public SolicitarProyecto(SolicitarProyectoId id, Estudiante estudiante, String justificacion, String fechaSolicitud) {
       this.id = id;
       this.estudiante = estudiante;
       this.justificacion = justificacion;
       this.fechaSolicitud = fechaSolicitud;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idEstudiante", column=@Column(name="id_estudiante", nullable=false) ), 
        @AttributeOverride(name="idProyecto", column=@Column(name="id_proyecto", nullable=false) ) } )
    public SolicitarProyectoId getId() {
        return this.id;
    }
    
    public void setId(SolicitarProyectoId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_estudiante", nullable=false, insertable=false, updatable=false)
    public Estudiante getEstudiante() {
        return this.estudiante;
    }
    
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    
    @Column(name="justificacion")
    public String getJustificacion() {
        return this.justificacion;
    }
    
    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    
    @Column(name="fecha_solicitud")
    public String getFechaSolicitud() {
        return this.fechaSolicitud;
    }
    
    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }




}


