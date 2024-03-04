package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.model.Autor;
import br.unitins.topicos1.repository.AutorRepository;
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

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/autores")
public class AutorResource {

    @Inject
    public AutorRepository autorRepository;

    @GET
    @Path("/{id}")
    public Autor findById(@PathParam("id") Long id){
        return autorRepository.findById(id);
    }

    @GET
    public List<Autor> findAll(){
        return autorRepository.listAll();
    }

    @GET
    @Path("/search/nome/{nome}")
    public List<Autor> findByNome(@PathParam("nome") String nome){
        return autorRepository.findByNome(nome);
    }

    @GET
    @Path("/search/biografia/{biografia}")
    public List<Autor> findByBiografia(@PathParam("biografia") String biogarfia){
        return autorRepository.findByNome(biogarfia);
    }

    @POST
    @Transactional
    public Autor create (Autor autor){
        autorRepository.persist(autor);
        return autor;
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void update(@PathParam("id") Long id, Autor nome, Autor biogarfia){
        Autor autorBanco = autorRepository.findById(id);

        autorBanco.setNome(nome.getNome());
        autorBanco.setBiografia(biogarfia.getBiografia());
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id){
        autorRepository.deleteById(id);
    }

    
}
