package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Editora;

public record EditoraResponseDTO(
    Long id,  
    String nome, 
    String email, 
    String endereco, 
    String estado, 
    TelefoneResponseDTO telefone
) {
    public static EditoraResponseDTO valueOf(Editora editora){
        return new EditoraResponseDTO(
            editora.getId(),
            editora.getNome(),
            editora.getEmail(),
            editora.getEndereco(),
            editora.getEstado(),
            TelefoneResponseDTO.valueOf(editora.getTelefone())
        );
    }
}
