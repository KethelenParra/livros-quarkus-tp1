package br.unitins.topicos1.dto;

import java.util.List;

import br.unitins.topicos1.model.Genero;

public record GeneroResponseDTO(
    Long id,  
    String name, 
    String descricao,
    List<LivroResponseDTO> livros
) {
    public static GeneroResponseDTO valueOf(Genero genero){
        List<LivroResponseDTO> lista = genero.getListaLivros()
                                             .stream()
                                             .map(LivroResponseDTO::valueOf)
                                             .toList();
        return new GeneroResponseDTO(
            genero.getId(),
            genero.getName(),
            genero.getDescricao(),
            lista
        );
    }
}
