package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.GeneroDTO;
import br.unitins.topicos1.service.GeneroService;
import jakarta.annotation.security.RolesAllowed;
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
@Path("/generos")
public class GeneroResource {

    @Inject
    public GeneroService generoService;

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findById(@PathParam("id") Long id){
        return Response.ok(generoService.findById(id)).build();
    }

    @GET
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findAll(){
        return Response.ok(generoService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findByNome(@PathParam("nome") String nome){
        return Response.ok(generoService.findByNome(nome)).build();
    }

    @GET
    @Path("/search/descricao/{descricao}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findByDescricao(@PathParam("descricao") String descricao){
        return Response.ok(generoService.findByDescricao(descricao)).build();
    }

    @POST
    @RolesAllowed({"Funcionario"})
    public Response create (GeneroDTO dto){
        return Response.status(Status.CREATED).entity(generoService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, GeneroDTO dto){
        generoService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id){
        generoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }    
}
