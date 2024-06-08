
package libcode.webapp.recursos;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import libcode.webapp.entidades.Alumno;

import libcode.webapp.negocio.DataService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/alumnos")
public class Recurso {
    
    @EJB DataService servicio;
    
    @GET
    public Response getAlumnos(){
        
        List<Alumno> alumnos = servicio.getAlumnos();
        
        return Response.ok(alumnos).build();
    }
    
    @POST
    public Response saveAlumno(Alumno alumno){
        
        servicio.saveAlumno(alumno);
        
        return Response.ok("El alumno fue creado exitosamente").build();
    }
    
    @PUT
    public Response editAlumno(Alumno alumno){
        
        servicio.editAlumno(alumno);
        
        return Response.ok("El alumno editado exitosamente").build();
    }
    
     @DELETE
     @Path("/{id}")
    public Response deleteAlumno(@PathParam("id") Integer id){
        
        servicio.deleteAlumno(new Alumno(id));
        
        return Response.ok("El alumno eliminado exitosamente").build();
    }
    
}
