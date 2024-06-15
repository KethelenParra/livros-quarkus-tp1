package br.unitins.topicos1.resource;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.AvaliacaoDTO;
import br.unitins.topicos1.dto.Response.AvaliacaoResponseDTO;
import br.unitins.topicos1.service.AvaliacaoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/avaliacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AvaliacaoResource {

    @Inject
    AvaliacaoService avaliacaoService;

    private static final Logger LOG = Logger.getLogger(AvaliacaoResource.class);

    @GET
    @RolesAllowed({ "Funcionario", "Cliente" })
    public List<AvaliacaoResponseDTO> findAll() {
        LOG.info("Buscando todas as avaliações");
        LOG.debug("ERRO DE DEBUG.");
        return avaliacaoService.findAll();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({ "Funcionario" })
    public AvaliacaoResponseDTO findById(@PathParam("id") Long id) throws NotFoundException {
        LOG.infof("Buscando avaliações por ID. ", id);
        LOG.debug("ERRO DE DEBUG.");
        return avaliacaoService.findById(id);
    }

    @POST
    @RolesAllowed({ "Cliente"})
    public Response create(AvaliacaoDTO avaliacaoDto) {
        try {
            AvaliacaoResponseDTO avaliacao = avaliacaoService.create(avaliacaoDto);
            LOG.infof("Produto inserido na lista Desejo.");

            return Response.status(Status.CREATED).entity(avaliacao).build();

        }catch (Exception e) {
            LOG.error("Erro ao inserir uma avaliação. ", e);
        }
        return Response.status(Status.NOT_FOUND).entity("Erro ao inserir uma avaliação. ").build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({ "Cliente" })
    public Response update(@PathParam("id") Long id, AvaliacaoDTO avaliacaoDto) {
        try {
            avaliacaoService.update(id, avaliacaoDto);

            LOG.infof("Avaliação atualizada com sucesso.", id);

            return Response.status(Status.NO_CONTENT).build(); //204
        }  catch (Exception e){       

            LOG.errorf("Erro ao atualizar a avaliação. ", id, e);
            
        }
        return Response.status(Status.NOT_FOUND).entity("Erro ao atualizar a avaliação.").build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({ "Funcionario", "Cliente"})
    public Response delete(@PathParam("id") Long id) throws IllegalArgumentException {

        try {
            avaliacaoService.delete(id);
            LOG.infof("avaliação excluída com sucesso.", id);
            return Response.status(Status.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            LOG.error("Erro ao deletar avaliação: parâmetros inválidos.", e);
            throw e;
        } 
    }

}
