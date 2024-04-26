package br.unitins.topicos1.dto;

import java.time.LocalDate;

public record FuncionarioDTO(
    Double salario,
    String cargo,
    String nome,
    LocalDate dataNascimento,
    String email,
    String senha,
    String cpf,
    Integer idSexo,
    TelefoneDTO telefone
) {}
