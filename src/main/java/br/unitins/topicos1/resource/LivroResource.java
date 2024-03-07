package br.unitins.topicos1.resource;

import java.util.List;

import br.unitins.topicos1.dto.LivroDTO;
import br.unitins.topicos1.dto.LivroResponseDTO;
import br.unitins.topicos1.model.Autor;
import br.unitins.topicos1.model.Livro;
import br.unitins.topicos1.repository.AutorRepository;
import br.unitins.topicos1.repository.LivroRepository;
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
@Path("/livros")
public class LivroResource {

    @Inject
    public LivroRepository livroRepository;

    @Inject
    public AutorRepository autorRepository;

    @GET
    @Path("/{id}")
    public LivroResponseDTO findById(@PathParam("id") Long id){
        return LivroResponseDTO.valueOf(livroRepository.findById(id));
    }

    @GET
    public List<LivroResponseDTO> findAll(){
        return livroRepository.listAll().stream().map(livro -> LivroResponseDTO.valueOf(livro)).toList();
    }

    @GET
    @Path("/search/titulo/{titulo}")
    public List<LivroResponseDTO> findByTitulo(@PathParam("titulo") String titulo){
        return livroRepository.findByTitulo(titulo).stream().map( livro -> LivroResponseDTO.valueOf(livro)).toList();
    }

    @GET
    @Path("/search/autor/{id}")
    public List<Livro> findByAutor(@PathParam("id") Long id_autor){
        Autor autor = autorRepository.findById(id_autor);
        return livroRepository.findByAutor(autor);
    }

    @GET
    @Path("/search/editora/{editora}")
    public List<LivroResponseDTO> findByEditora(@PathParam("editora") String editora){
        return livroRepository.findByEditora(editora).stream().map( livro -> LivroResponseDTO.valueOf(livro)).toList();
    }

    @GET
    @Path("/search/genero/{genero}")
    public List<LivroResponseDTO> findByGenero(@PathParam("genero") String genero){
        return livroRepository.findByGenero(genero).stream().map( livro -> LivroResponseDTO.valueOf(livro)).toList();
    }

    @GET
    @Path("/search/descricao/{descricao}")
    public List<LivroResponseDTO> findByDescricao(@PathParam("descricao") String descricao){
        return livroRepository.findByDescricao(descricao).stream().map( livro -> LivroResponseDTO.valueOf(livro)).toList();
    }

    @POST
    @Transactional
    public LivroResponseDTO create (LivroDTO dto){

        Livro livro = new Livro();
        
        livro.setTitulo(dto.titulo());
        livro.setAutor(autorRepository.findById(dto.id_autor()));
        livro.setEditora(dto.editora());
        livro.setGenero(dto.genero());
        livro.setPreco(dto.preco());
        livro.setQuantidadeEstoque(dto.quantidadeEstoque());
        livro.setIsbn(dto.isbn());
        livro.setDataLancamento(dto.dataLancamento());
        livro.setDataCadastro(dto.dataCadastro());
        livro.setDescricao(dto.descricao());

        livroRepository.persist(livro);
        return LivroResponseDTO.valueOf(livro);
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public void update(@PathParam("id") Long id, LivroDTO dto){
        Livro livro = livroRepository.findById(id);

        livro.setTitulo(dto.titulo());
        livro.setAutor(autorRepository.findById(dto.id_autor()));
        livro.setEditora(dto.editora());
        livro.setGenero(dto.genero());
        livro.setPreco(dto.preco());
        livro.setQuantidadeEstoque(dto.quantidadeEstoque());
        livro.setDescricao(dto.descricao());
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id){
        livroRepository.deleteById(id);
    }

    
}
