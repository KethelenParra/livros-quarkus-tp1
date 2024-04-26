package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.LivroDTO;
import br.unitins.topicos1.service.LivroService;
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
@Path("/livros")
public class LivroResource {

    @Inject
    public LivroService livroService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        return Response.ok(livroService.findById(id)).build();
    }

    @GET
    public Response findAll(){
        return Response.ok(livroService.findAll()).build();
    }

    @GET
    @Path("/search/titulo/{titulo}")
    public Response findByTitulo(@PathParam("titulo") String titulo){
        return Response.ok(livroService.findByTitulo(titulo)).build();
    }

    @GET
    @Path("/search/isbn/{isbn}")
    public Response findByIsbn(@PathParam("isbn") String isbn){
        return Response.ok(livroService.findByIsbn(isbn)).build();
    }

    @GET
    @Path("/search/descricao/{descricao}")
    public Response findByDescricao(@PathParam("descricao") String descricao){
        return Response.ok(livroService.findByDescricao(descricao)).build();
    }

    @POST
    public Response create (LivroDTO dto){
        return Response.status(Status.CREATED).entity(livroService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, LivroDTO dto){
        livroService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        livroService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }    
}
