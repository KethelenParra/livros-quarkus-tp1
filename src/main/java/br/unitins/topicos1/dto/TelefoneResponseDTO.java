package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Telefone;

public record TelefoneResponseDTO(
    String codigoArea,
    String numero
) {
    public static TelefoneResponseDTO valueOf(Telefone t){
        return new TelefoneResponseDTO(t.getCodigoArea(), t.getNumero());
    }
    
    
}
