package br.unitins.topicos1.dto;

import java.time.LocalDate;

import br.unitins.topicos1.model.Livro;

public record LivroResponseDTO (Long id,
    String titulo,
    AutorResponseDTO autor,
    String editora,
    String genero,
    Double preco,
    Integer quantidadeEstoque,
    String isbn,
    LocalDate dataLancamento,
    LocalDate dateCadastro,
    String descricao
) {
    public static LivroResponseDTO valueOf(Livro livro){
        return new LivroResponseDTO(
            livro.getId(),
            livro.getTitulo(),
            AutorResponseDTO.valueOf(livro.getAutors()),
            livro.getEditora(),
            livro.getGenero(),
            livro.getPreco(),
            livro.getQuantidadeEstoque(),
            livro.getIsbn(),
            livro.getDataLancamento(),
            livro.getDateCadastro(),
            livro.getDescricao());
    }
    
}
