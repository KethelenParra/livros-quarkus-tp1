package br.unitins.topicos1.dto;

import java.time.LocalDate;

public record UsuarioDTO(
    String nome,
    String username,
    String senha,
    LocalDate dataNascimento,
    String email,
    TelefoneDTO telefone,
    Integer idSexo,
    String cpf


) {

}
