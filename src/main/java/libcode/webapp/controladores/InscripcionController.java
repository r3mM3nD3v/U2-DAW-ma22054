
package libcode.webapp.controladores;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import libcode.webapp.entidades.Inscripcion;
import libcode.webapp.negocio.DataService;

@Named
@RequestScoped
public class InscripcionController {
    private List<Inscripcion> inscripcionList = new ArrayList<>();
    
    private Inscripcion inscripcion = new Inscripcion();
    
    @EJB 
    DataService servicio;
    
    @PostConstruct
    public void cargarInscripcion(){
       inscripcionList = servicio.getInscripciones();
    }
    
    // CRUD de la pagina
    
    public void guardarInscripcion(){
        if(inscripcion.getId()!=null){
            servicio.editInscripcion(inscripcion);
        }else{
            servicio.saveInscripcion(inscripcion);
        }               
        inscripcion = new Inscripcion();
        cargarInscripcion();
    }
    
    public void editarInscripcion(Inscripcion inscripcion){
        this.inscripcion.setId(Integer.SIZE);
        this.inscripcion.setAlumno(inscripcion.getAlumno());
        this.inscripcion.setMateria(inscripcion.getMateria());
        this.inscripcion.setCiclo(inscripcion.getCiclo());
        this.inscripcion.setAno(inscripcion.getAno());
        this.inscripcion.setFecha_inscripcion(inscripcion.getFecha_inscripcion());
    }
    
    public void eliminarInscripcion(Inscripcion inscripcion){
        servicio.deleteInscripcion(inscripcion);
        cargarInscripcion();
    }
    //Para la lista
    
    public List<Inscripcion> getInscripcionList(){
        return inscripcionList;
    }
    
    public void setInscripcionList(List<Inscripcion> inscripcionList){
        this.inscripcionList = inscripcionList;
    }
    
    //Para clase Inscripcion:

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }
}
