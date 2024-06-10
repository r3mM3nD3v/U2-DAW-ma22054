
package libcode.webapp.negocio;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import libcode.webapp.entidades.Materia;

@Stateless            
public class DataServicematerias {
    
    @PersistenceContext(unitName = "pu")
    EntityManager entityManager;
    
    public List<Materia> getMaterias(){
        
        Query query = entityManager.createQuery("SELECT e FROM Materia e ORDER BY e.id DESC");
        
        List<Materia> Materias = query.getResultList();
        
        return Materias;
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
}