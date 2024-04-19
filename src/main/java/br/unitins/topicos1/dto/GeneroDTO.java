package br.unitins.topicos1.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public record GeneroDTO(
    String name, 
	@NotEmpty(message = "A descrição deve ser informada.")
    String Descricao,
    List<LivroDTO> livros
) {}
