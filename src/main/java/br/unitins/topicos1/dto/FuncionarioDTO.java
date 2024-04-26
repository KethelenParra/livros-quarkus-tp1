package br.unitins.topicos1.dto;

public record FuncionarioDTO(
    Double salario,
    String cargo,
    Long usuario,
    String nome,
    String dataNascimento,
    String email,
    String senha,
    String cpf,
    Integer idSexo,
    TelefoneDTO telefone
) {}
