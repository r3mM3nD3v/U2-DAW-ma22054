/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.webapp.controladores;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import libcode.webapp.entidades.Materia;
import libcode.webapp.negocio.DataService;
/**
 *
 * @author Gabo
 */
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
        this.materia.setNombre(materia.getNombre());
        this.materia.setDescripcion(materia.getDescripcion());
        this.materia.setCodigo(materia.getCodigo());
    }
    
    public void eliminarMateria(Materia materia)
    {
        servicio.deleteMateria(materia);
        cargarMaterias();
    }
}
