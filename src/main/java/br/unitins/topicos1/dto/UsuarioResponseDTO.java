package br.unitins.topicos1.dto;

import java.time.LocalDate;

import br.unitins.topicos1.model.Sexo;
import br.unitins.topicos1.model.Usuario;

public record UsuarioResponseDTO(
    Long id,
    String nome,
    LocalDate dataNascimento,
    String email,
    String senha,
    TelefoneResponseDTO telefone,
    Sexo sexo,
    String cpf
) {
    public static UsuarioResponseDTO valueOf(Usuario usuario){
        return new UsuarioResponseDTO(
            usuario.getId(),
            usuario.getNome(), 
            usuario.getDataNascimento(),
            usuario.getEmail(),
            usuario.getSenha(),
            TelefoneResponseDTO.valueOf(usuario.getTelefone()), 
            usuario.getSexo(),
            usuario.getCpf()
        );
    }
}
