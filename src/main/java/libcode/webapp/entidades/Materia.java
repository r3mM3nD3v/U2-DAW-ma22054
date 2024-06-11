package libcode.webapp.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Column;
import java.util.Objects;
import java.io.Serializable;

@Entity
@Table(name = "materias")
public class Materia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "materia_id_seq")
    @SequenceGenerator(name = "materia_id_seq", sequenceName = "materia_id_seq", allocationSize = 1)
    
    @Column(name = "id")
    private Integer id;
   
    @Column(name = "materia")
    private String materia;
    
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "codigomateria")
    private String codigomateria;

    public Materia(Integer id, String materia, String descripcion, String codigomateria) {
        this.id = id;
        this.materia = materia;
        this.descripcion = descripcion;
        this.codigomateria = codigomateria;
    }

    public Materia(Integer id) {
        this.id = id;
    }
    
    public Materia() {
        
    }
    
    public Materia(Integer id, String materia) {
        this.id = id;
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Materia{" + "id=" + id + ", materia=" + materia + ", descripcion=" + descripcion + ", codigomateria=" + codigomateria + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Materia other = (Materia) obj;
        return Objects.equals(this.id, other.id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigomateria() {
        return codigomateria;
    }

    public void setCodigomateria(String codigomateria) {
        this.codigomateria = codigomateria;
    }
}
