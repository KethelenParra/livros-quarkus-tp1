package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.service.FuncionarioService;
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
@Path("/funcionarios")
public class FuncionarioResource {

    @Inject
    public FuncionarioService funcionarioService;

    @GET
    public Response findAll() {
        return Response.ok(funcionarioService.findAll()).build();
    }

    @GET
    @Path("/search/cargo/{cargo}")
    public Response findByCargo(@PathParam("cargo") String cargo) {
        return Response.ok(funcionarioService.findByCargo(cargo)).build();
    }

    @GET
    @Path("/search/cpf/{cpf}")
    public Response findByCpf(@PathParam("cpf") String cpf) {
        return Response.ok(funcionarioService.findByCpf(cpf)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(funcionarioService.findById(id)).build();
    }

    @POST
    public Response create(@Valid FuncionarioDTO dto) {
        return Response.status(Status.CREATED).entity(funcionarioService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, FuncionarioDTO dto) {
        funcionarioService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        funcionarioService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

}
