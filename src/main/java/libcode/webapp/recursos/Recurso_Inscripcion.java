
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
import libcode.webapp.entidades.Inscripcion;

import libcode.webapp.negocio.DataService;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/inscripciones")
public class Recurso_Inscripcion {
    @EJB DataService servicio;
    
    @GET
    public Response getInscripciones(){
        
        List<Inscripcion> inscripciones = servicio.getInscripciones();
        
        return Response.ok(inscripciones).build();
    }
    
    @POST
    public Response saveInscripcion(Inscripcion inscripcion){
        
        servicio.saveInscripcion(inscripcion);
        
        return Response.ok("La inscripcion fue creada exitosamente").build();
    }
    
    @PUT
    public Response editInscripcion(Inscripcion inscripcion){
        
        servicio.editInscripcion(inscripcion);
        
        return Response.ok("La inscripcion ha sido editada exitosamente").build();
    }
    
     @DELETE
     @Path("/{id}")
    public Response deleteInscripcion(@PathParam("id") Integer id){
        
        servicio.deleteInscripcion(new Inscripcion(id));
        
        return Response.ok("La inscripcion ha sido eliminada exitosamente").build();
    }
    
    
}
