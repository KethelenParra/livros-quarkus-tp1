package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.dto.AutorDTO;
import br.unitins.topicos1.dto.AutorResponseDTO;
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
    public AutorResponseDTO findById(@PathParam("id") Long id){
        return AutorResponseDTO.valueOf(autorRepository.findById(id));
    }

    @GET
    public List<AutorResponseDTO> findAll(){
        return autorRepository.listAll().stream().map(e -> AutorResponseDTO.valueOf(e)).toList();
    }

    @GET
    @Path("/search/nome/{nome}")
    public List<AutorResponseDTO> findByNome(@PathParam("nome") String nome){
        return autorRepository.findByNome(nome).stream().map(e -> AutorResponseDTO.valueOf(e)).toList();
    }

    @GET
    @Path("/search/biografia/{biografia}")
    public List<AutorResponseDTO> findByBiografia(@PathParam("biografia") String biogarfia){
        return autorRepository.findByNome(biogarfia).stream().map(e -> AutorResponseDTO.valueOf(e)).toList();
    }

    @POST
    @Transactional
    public AutorResponseDTO create (AutorDTO dto){
        Autor autor = new Autor();
        autor.setNome(dto.nome());
        autor.setBiografia(dto.biografia());

        autorRepository.persist(autor);
        return AutorResponseDTO.valueOf(autor);
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
