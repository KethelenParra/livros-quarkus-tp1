package br.unitins.topicos1.service;

import java.util.ArrayList;
import java.util.List;

import br.unitins.topicos1.dto.EditoraDTO;
import br.unitins.topicos1.dto.LivroDTO;
import br.unitins.topicos1.dto.LivroResponseDTO;
import br.unitins.topicos1.model.Autor;
import br.unitins.topicos1.model.Classificacao;
import br.unitins.topicos1.model.Editora;
import br.unitins.topicos1.model.Fornecedor;
import br.unitins.topicos1.model.Livro;
import br.unitins.topicos1.repository.AutorRepository;
import br.unitins.topicos1.repository.EditoraRepository;
import br.unitins.topicos1.repository.GeneroRepository;
import br.unitins.topicos1.repository.LivroRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class LivroServiceImpl implements LivroService{

    @Inject
    public LivroRepository livroRepository;

    @Inject
    public AutorRepository autorRepository;

    @Inject
    public EditoraRepository editoraRepository;

    @Inject
    public GeneroRepository generoRepository;

    @Override
    @Transactional
    public LivroResponseDTO create(@Valid LivroDTO dto){
        Livro livro = new Livro();
        livro.setTitulo(dto.titulo());
        livro.setQuantidadeEstoque(dto.quantidadeEstoque());
        livro.setIsbn(dto.isbn());
        livro.setDescricao(dto.descricao());
        livro.setClassificacao(Classificacao.valueOf(dto.id_classificacao()));
        livro.setListaAutor((dto.autores()).stream().map(a -> autorRepository.findById(a)).toList());
        livro.setListaGenero(dto.generos().stream().map(g -> generoRepository.findById(g)).toList());
        livro.setEditora(editoraRepository.findById(dto.editora()));


        livroRepository.persist(livro);
        return LivroResponseDTO.valueOf(livro);
    }

    @Override
    @Transactional
    public void update(Long id, LivroDTO dto){
        Livro livroBanco = livroRepository.findById(id);

        livroBanco.setTitulo(dto.titulo());
        livroBanco.setQuantidadeEstoque(dto.quantidadeEstoque());
        livroBanco.setIsbn(dto.isbn());
        livroBanco.setDescricao(dto.descricao());
        livroBanco.setClassificacao(Classificacao.valueOf(dto.id_classificacao()));
        livroBanco.setListaAutor((dto.autores()).stream().map(a -> autorRepository.findById(a)).toList());
        livroBanco.setListaGenero(dto.generos().stream().map(g -> generoRepository.findById(g)).toList());
        livroBanco.setEditora(editoraRepository.findById(dto.editora()));
    }

    @Override
    @Transactional
    public void delete(Long id){
        livroRepository.deleteById(id);
    }

    @Override
    public LivroResponseDTO findById(Long id){
        return LivroResponseDTO.valueOf(livroRepository.findById(id));
    }

    @Override
    public List<LivroResponseDTO> findAll(){
        return livroRepository.listAll().stream().map(livro -> LivroResponseDTO.valueOf(livro)).toList();
    }

    @Override
    public List<LivroResponseDTO> findByTitulo(String titulo) {
        return livroRepository.findByTitulo(titulo).stream()
        .map(e -> LivroResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<LivroResponseDTO> findByQuantidadeEstoque(Integer quantidadeEstoque) {
        return livroRepository.findByQuantidadeEstoque(quantidadeEstoque).stream()
        .map(e -> LivroResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<LivroResponseDTO> findByIsbn(String isbn) {
        return livroRepository.findByIsbn(isbn).stream()
        .map(e -> LivroResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<LivroResponseDTO> findByDescricao(String descricao) {
        return livroRepository.findByDescricao(descricao).stream()
        .map(e -> LivroResponseDTO.valueOf(e)).toList();
    }

}
