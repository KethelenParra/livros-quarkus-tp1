package br.unitins.topicos1.dto;

import java.time.LocalDate;

public record LivroDTO( String titulo,
                        Long id_autor,
                        String editora,
                        String genero,
                        Double preco,
                        Integer quantidadeEstoque,
                        String isbn,
                        LocalDate dataLancamento,
                        LocalDate dataCadastro,
                        String descricao
                      ) {}
   
