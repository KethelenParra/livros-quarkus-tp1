package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Genero;

public record GeneroResponseDTO(
    Long id,  
    String name, 
    String descricao
) {
    public static GeneroResponseDTO valueOf(Genero genero){
        return new GeneroResponseDTO(
            genero.getId(),
            genero.getNome(),
            genero.getDescricao()
        );
    }
}
