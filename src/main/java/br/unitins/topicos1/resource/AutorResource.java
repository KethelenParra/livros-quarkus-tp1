package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.AutorDTO;
import br.unitins.topicos1.service.AutorService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
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
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/autores")
public class AutorResource {

    @Inject
    public AutorService autorService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        return Response.ok(autorService.findById(id)).build();
    }

    @GET
    public Response findAll(){
        return Response.ok(autorService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome){
        return Response.ok(autorService.findByNome(nome)).build();
    }

    @GET
    @Path("/search/biografia/{biografia}")
    public Response findByBiografia(@PathParam("biografia") String biografia){
        return Response.ok(autorService.findByBiografia(biografia)).build();
    }

    @POST
    public Response create(@Valid AutorDTO dto){
        return Response.status(Status.CREATED).entity(autorService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, AutorDTO dto){
        autorService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
       autorService.delete(id);
       return Response.status(Status.NO_CONTENT).build();
    }
   
}
