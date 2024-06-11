/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import libcode.webapp.entidades.Materia;
import libcode.webapp.negocio.DataService;
/**
 *
 * @author Gabo
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/materias")
public class Recurso_Materia {
    @EJB DataService servicio;
    
    @GET
    public Response getMaterias()
    {
        List<Materia> materias = servicio.getMaterias();
        return Response.ok(materias).build();
    }
    
    @POST
    public Response saveMateria(Materia materia)
    {
        servicio.saveMateria(materia);
        return Response.ok("La materia fue creada exitosamente").build();
    }
    
    @PUT
    public Response editMateria(Materia materia)
    {
        servicio.editMateria(materia);
        return Response.ok("La materia fue editada exitosamente").build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteMateria(@PathParam("id") Integer id)
    {
        servicio.deleteMateria(new Materia(id));
        return Response.ok("La materia fue eliminada exitosamente").build();
    }
}
