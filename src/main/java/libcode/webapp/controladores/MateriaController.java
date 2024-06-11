
package libcode.webapp.controladores;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import libcode.webapp.entidades.Materia;
import libcode.webapp.negocio.DataService;

@Named
@RequestScoped
public class MateriaController {
    private List<Materia> materiasList = new ArrayList<>();
    private Materia materia = new Materia();
    
    
    @EJB
    DataService servicio;
    
    @PostConstruct
    public void cargarMaterias() {
        materiasList = servicio.getMaterias();
    }
    
    public List<Materia> getMateriasList() {
        return materiasList;
    }

    public void setMateriasList(List<Materia> materiasList) {
        this.materiasList = materiasList;
    }
    
    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    public void llenarFormEditar(Materia materia)
    {
        this.materia.setId(materia.getId());
        this.materia.setMateria(materia.getMateria());
        this.materia.setDescripcion(materia.getDescripcion());
        this.materia.setCodigomateria(materia.getCodigomateria());
    }
    
    public void eliminarMateria(Materia materia)
    {
        servicio.deleteMateria(materia);
        cargarMaterias();
    }
}
