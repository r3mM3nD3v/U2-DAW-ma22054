
package libcode.webapp.negocio;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import libcode.webapp.entidades.Alumno;
import libcode.webapp.entidades.Inscripcion;
import libcode.webapp.entidades.Materia;

@Stateless            
public class DataService {
    
    
    //Alumno
    
    @PersistenceContext(unitName = "pu")
    EntityManager entityManager;
    
    public List<Alumno> getAlumnos(){
        
        Query query = entityManager.createQuery("SELECT e FROM Alumno e ORDER BY e.id DESC");
        
        List<Alumno> alumnos = query.getResultList();
        
        return alumnos;
    }
    
    @Transactional
    public void saveAlumno(Alumno alumno){
        entityManager.persist(alumno);
    }
    
    @Transactional
    public void editAlumno(Alumno alumno){
        entityManager.merge(alumno);
    }
    
    @Transactional
    public void deleteAlumno(Alumno alumno){
        Alumno alumnoEliminar = entityManager.find(Alumno.class, alumno.getId());
        entityManager.remove(alumnoEliminar);
    }
    
    
    //Materias
    public List<Materia> getMaterias(){
        
        Query query = entityManager.createQuery("SELECT e FROM Materia e ORDER BY e.id DESC");
        
        List<Materia> Materia = query.getResultList();
        
        return Materia;
    }
    
    @Transactional
    public void saveMateria(Materia Materia){
        entityManager.persist(Materia);
    }
    
    @Transactional
    public void editMateria(Materia Materia){
        entityManager.merge(Materia);
    }
    
    @Transactional
    public void deleteMateria(Materia Materia){
        Materia MateriaEliminar = entityManager.find(Materia.class, Materia.getId());
        entityManager.remove(MateriaEliminar);
    }
    
    //Inscripciones
    
    public List<Inscripcion> getInscripciones(){
        
        TypedQuery<Inscripcion> query = entityManager.createQuery("SELECT e FROM Inscripcion e ORDER BY e.id DESC", Inscripcion.class);
        return query.getResultList();
    }
    
    @Transactional
    public void saveInscripcion(Inscripcion inscripcion){
        entityManager.persist(inscripcion);
    }
    
    @Transactional
    public void editInscripcion(Inscripcion inscripcion){
        entityManager.merge(inscripcion);
    }
    
    @Transactional
    public void deleteInscripcion(Inscripcion inscripcion){
        Inscripcion inscripcionEliminar = entityManager.find(Inscripcion.class, inscripcion.getId());
        entityManager.remove(inscripcionEliminar);
    }
    
}