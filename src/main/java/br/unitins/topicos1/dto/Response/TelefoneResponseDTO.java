package br.unitins.topicos1.dto.Response;

import br.unitins.topicos1.model.telefone.Telefone;

public record TelefoneResponseDTO(
    String codigoArea,
    String numero
) {
    public static TelefoneResponseDTO valueOf(Telefone telefone){
        return new TelefoneResponseDTO(
            telefone.getCodigoArea(), 
            telefone.getNumero());
    } 
}
