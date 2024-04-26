package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Funcionario;

public record FuncionarioResponseDTO(
    Long id,
    Double salario,
    String cargo,
    UsuarioResponseDTO usuario
) {
    public static FuncionarioResponseDTO valueOf(Funcionario funcionario){
        return new FuncionarioResponseDTO(
            funcionario.getId(),
            funcionario.getSalario(),
            funcionario.getCargo(),
            UsuarioResponseDTO.valueOf(funcionario.getUsuario()));
    }
}
