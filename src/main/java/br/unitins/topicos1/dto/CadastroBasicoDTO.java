package br.unitins.topicos1.dto;

public record CadastroBasicoDTO(
    String nome, 
    String email,
    String username,
    String senha,
    Integer idSexo
) {
    
}