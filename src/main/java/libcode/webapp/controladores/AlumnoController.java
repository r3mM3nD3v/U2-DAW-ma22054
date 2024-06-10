
package libcode.webapp.controladores;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import java.util.List;
import java.util.ArrayList;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import libcode.webapp.entidades.Alumno;
import libcode.webapp.negocio.DataService;

@Named
@RequestScoped
public class AlumnoController {
    
    private List<Alumno> alumnosList = new ArrayList<>();
    
    private Alumno alumno = new Alumno();
    
    @EJB 
    DataService servicio;
    
    @PostConstruct
    public void cargarAlumnos(){
       alumnosList = servicio.getAlumnos();
    }
    
    // CRUD de la pagina
    
    public void guardarAlumno(){
        if(alumno.getId()!=null){
            servicio.editAlumno(alumno);
        }else{
            servicio.saveAlumno(alumno);
        }               
        alumno = new Alumno();
        cargarAlumnos();
    }
    
    public void editarAlumno(Alumno alumno){
        this.alumno.setId(alumno.getId());
        this.alumno.setNombre(alumno.getNombre());
        this.alumno.setCarnet(alumno.getCarnet());
    }
    
    public void eliminarAlumno(Alumno alumno){
        servicio.deleteAlumno(alumno);
        cargarAlumnos();
    }
    //Para la lista
    
    public List<Alumno> getAlumnosList(){
        return alumnosList;
    }
    
    public void setAlumnosList(List<Alumno> alumnosList){
        this.alumnosList = alumnosList;
    }
    
    //Para clase Alumno:

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
}
