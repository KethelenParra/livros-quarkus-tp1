package br.unitins.topicos1.resource;


import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.service.TelefoneService;
import jakarta.inject.Inject;
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
@Path("/telefones")
public class TelefoneResource {
    
    @Inject
    public TelefoneService telefoneService;

    @GET

    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(telefoneService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(telefoneService.findAll()).build();
    }

    @POST
    public Response create(TelefoneDTO dto) {
        return Response.status(Status.CREATED).entity(telefoneService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, TelefoneDTO dto) {
        telefoneService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        telefoneService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }


}
