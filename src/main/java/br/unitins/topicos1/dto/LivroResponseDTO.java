package br.unitins.topicos1.dto;

import java.time.LocalDate;
import java.util.List;

import br.unitins.topicos1.model.Classificacao;
import br.unitins.topicos1.model.Livro;

public record LivroResponseDTO (
                        Long id,
                        String titulo,
                        List<AutorResponseDTO> autores,
                        EditoraResponseDTO editora,
                        List<GeneroResponseDTO> generos,
                        Double preco,
                        Integer quantidadeEstoque,
                        String isbn,
                        LocalDate dataLancamento,
                        Classificacao id_classificacao,
                        String descricao,
                        FornecedorResponseDTO fornecedor
) {
    public static LivroResponseDTO valueOf(Livro livro){
        List<AutorResponseDTO> listaAutor = livro.getListaAutor()
                                                .stream()
                                                .map(AutorResponseDTO::valueOf)
                                                .toList();
        List<GeneroResponseDTO> listaGenero = livro.getListaGenero()
                                                .stream()
                                                .map(GeneroResponseDTO::valueOf)
                                                .toList();
        return new LivroResponseDTO(
            livro.getId(),
            livro.getTitulo(),
            listaAutor,
            EditoraResponseDTO.valueOf(livro.getEditora()),
            listaGenero,
            livro.getPreco(),
            livro.getQuantidadeEstoque(),
            livro.getIsbn(),
            livro.getDataLancamento(),
            livro.getClassificacao(),
            livro.getDescricao(),
            FornecedorResponseDTO.valueOf(livro.getFornecedor())
        );
    }
}
