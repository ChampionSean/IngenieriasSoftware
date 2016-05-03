package pTitulo;
// Generated Apr 26, 2016 2:53:12 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SolicitarProyectoId generated by hbm2java
 */
@Embeddable
public class SolicitarProyectoId  implements java.io.Serializable {


     private int idEstudiante;
     private int idProyecto;

    public SolicitarProyectoId() {
    }

    public SolicitarProyectoId(int idEstudiante, int idProyecto) {
       this.idEstudiante = idEstudiante;
       this.idProyecto = idProyecto;
    }
   


    @Column(name="id_estudiante", nullable=false)
    public int getIdEstudiante() {
        return this.idEstudiante;
    }
    
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }


    @Column(name="id_proyecto", nullable=false)
    public int getIdProyecto() {
        return this.idProyecto;
    }
    
    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SolicitarProyectoId) ) return false;
		 SolicitarProyectoId castOther = ( SolicitarProyectoId ) other; 
         
		 return (this.getIdEstudiante()==castOther.getIdEstudiante())
 && (this.getIdProyecto()==castOther.getIdProyecto());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdEstudiante();
         result = 37 * result + this.getIdProyecto();
         return result;
   }   


}

