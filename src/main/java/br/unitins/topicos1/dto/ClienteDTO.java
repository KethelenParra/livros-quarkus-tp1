package br.unitins.topicos1.dto;

import java.time.LocalDate;

public record ClienteDTO(
    String cep,
    String endereco,
    String estado,
    String cidade, 
    String nome,
    LocalDate dataNascimento,
    String email,
    String senha,
    String cpf,
    Integer idSexo,
    TelefoneDTO telefone
) { }
