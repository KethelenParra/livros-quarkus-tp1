package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Cliente;

public record ClienteResponseDTO(
    Long id,
    String cep,
    String endereco,
    String estado,
    String cidade,
    UsuarioResponseDTO usuario
) {
    public static ClienteResponseDTO valueOf(Cliente cliente){
        return new ClienteResponseDTO(
            cliente.getId(),
            cliente.getCep(),
            cliente.getEndereco(),
            cliente.getEstado(),
            cliente.getCidade(),
            UsuarioResponseDTO.valueOf(cliente.getUsuario()));
    }
}
