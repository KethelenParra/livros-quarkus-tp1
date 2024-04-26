package br.unitins.topicos1.dto;

import java.time.LocalDate;

public record UsuarioDTO(
    String nome,
    LocalDate dataNascimento,
    String email,
    String senha,
    TelefoneDTO telefone,
    Integer idSexo,
    String cpf

) {

}
