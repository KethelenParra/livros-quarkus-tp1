package br.unitins.topicos1.dto;

public record ClienteDTO(
    String cep,
    String endereco,
    String estado,
    String cidade, 
    Long usuario,
    String nome,
    String dataNascimento,
    String email,
    String senha,
    String cpf,
    Integer idSexo,
    TelefoneDTO telefone
) { }
