package br.unitins.topicos1.dto;

import java.util.List;

import br.unitins.topicos1.model.Autor;

public record AutorResponseDTO(Long id, String nome, String biografia, List<LivroResponseDTO> livros) {

    public static AutorResponseDTO valueOf(Autor autor){
        List<LivroResponseDTO> lista = autor.getListaLivros()
                                            .stream()
                                            .map(LivroResponseDTO::valueOf)
                                            .toList();
        return new AutorResponseDTO(
            autor.getId(),
            autor.getNome(),
            autor.getBiografia(),
            lista);
    }
    
}
