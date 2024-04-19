package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.EditoraDTO;
import br.unitins.topicos1.service.EditoraService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
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
@Path("/editoras")
public class EditoraResource {

    @Inject
    public EditoraService editoraService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        return Response.ok(editoraService.findById(id)).build();
    }

    @GET
    public Response findAll(){
        return Response.ok(editoraService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome){
        return Response.ok(editoraService.findByNome(nome)).build();
    }

    @GET
    @Path("/search/estado/{estado}")
    public Response findByEstado(@PathParam("estado") String estado){
        return Response.ok(editoraService.findByEstado(estado)).build();
    }

    @POST
    @Transactional
    public Response create (EditoraDTO dto){
        return Response.status(Status.CREATED).entity(editoraService.create(dto)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, EditoraDTO dto){
        editoraService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        editoraService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }    
}
