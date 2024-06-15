package br.unitins.topicos1.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioDTO(
    @NotBlank(message = "O campo nome não pode estar nulo")
    String nome,

    @NotBlank(message = "O campo username não pode estar nulo")
    String username,

    @NotBlank(message = "O campo senha não pode estar nulo")
    String senha,
    LocalDate dataNascimento,

    @NotBlank(message = "O campo email não pode estar nulo")
    String email,
    TelefoneDTO telefone,
    Integer idSexo,

    @NotBlank(message = "O campo CPF não pode estar nulo")
    @Size(max = 11, min = 11, message = "O cpf tem que ter no mínimo 11 dígitos e deve conter apenas os números")
    String cpf
) { }
