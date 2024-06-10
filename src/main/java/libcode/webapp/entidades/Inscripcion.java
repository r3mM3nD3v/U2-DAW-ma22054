
package libcode.webapp.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name= "inscripciones")
public class Inscripcion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscripciones_id_seq")
    @SequenceGenerator(name = "inscripciones_id_seq", sequenceName = "inscripciones_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    
    @Column(name= "alumno_id")
    private String alumno;
    
    @Column(name= "materia_id")
    private String materia;
    
    @Column(name= "ciclo")
    private String ciclo;
    
    @Column(name= "ano")
    private String ano;
    
    @Column(name= "fecha_inscripcion")
    private String fecha_inscripcion;
    
    //Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(String fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }
    
    //equals and hashcode

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscripcion other = (Inscripcion) obj;
        return Objects.equals(this.id, other.id);
    }
    
    //to String

    @Override
    public String toString() {
        return "Inscripcion{" + "id=" + id + ", alumno=" + alumno + ", materia=" + materia + ", ciclo=" + ciclo + ", ano=" + ano + ", fecha_inscripcion=" + fecha_inscripcion + '}';
    }
    
    // constructores
    
    public Inscripcion(Integer id){
        this.id = id;
    }
    
    public Inscripcion(Integer id, String alumno, String materia, String ciclo, String ano, String fecha_inscripcion){
        this.id=id;
        this.alumno=alumno;
        this.materia=materia;
        this.ciclo=ciclo;
        this.ano=ano;
        this.fecha_inscripcion=fecha_inscripcion;
    }
    
    public Inscripcion(){
        
    }
    
    public Inscripcion(Integer id, String alumno, String materia){
        this.id = id;
        this.alumno=alumno;
        this.materia=materia;
    }
}
