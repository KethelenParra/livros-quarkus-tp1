package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.EditoraDTO;
import br.unitins.topicos1.service.EditoraService;
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
@Path("/editoras")
public class EditoraResource {

    @Inject
    public EditoraService editoraService;

    private static final Logger LOG = Logger.getLogger(EditoraResource.class);

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response findById(@PathParam("id") Long id){
        LOG.info("Buscando editora por id: " + id);
        return Response.ok(editoraService.findById(id)).build();
    }

    @GET
    @RolesAllowed({"Funcionario"})
    public Response findAll(){
        LOG.info("Buscando todas as editoras");
        return Response.ok(editoraService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    @RolesAllowed({"Funcionario"})
    public Response findByNome(@PathParam("nome") String nome){
        LOG.info("Buscando editora por nome: " + nome);
        return Response.ok(editoraService.findByNome(nome)).build();
    }

    @GET
    @Path("/search/estado/{estado}")
    @RolesAllowed({"Funcionario"})
    public Response findByEstado(@PathParam("estado") String estado){
        LOG.info("Buscando todas as editora por estado: " + estado);
        return Response.ok(editoraService.findByEstado(estado)).build();
    }

    @POST
    @RolesAllowed({"Funcionario"})
    public Response create (EditoraDTO dto){
        try {
            LOG.info("Editora criado com sucesso");
            return Response.status(Status.CREATED).entity(editoraService.create(dto)).build();
        } catch (Exception e) {
            LOG.error("Erro ao cadastrar editora", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao cadastrar editora").build();
        }
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, EditoraDTO dto){
        try {
            LOG.info("Editora atualizado com sucesso");
            editoraService.update(id, dto);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao atualizar editora", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao atualizar editora").build();
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id){
        try {
            LOG.info("Editora deletado com sucesso");
            editoraService.delete(id);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao deletar editora", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao deletar editora").build();
        }
    }    
}
