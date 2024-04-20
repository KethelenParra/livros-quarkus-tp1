package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Autor;

public record AutorResponseDTO(Long id, String nome, String biografia) {

    public static AutorResponseDTO valueOf(Autor autor){
        return new AutorResponseDTO(
            autor.getId(),
            autor.getNome(),
            autor.getBiografia());
    }
    
}
