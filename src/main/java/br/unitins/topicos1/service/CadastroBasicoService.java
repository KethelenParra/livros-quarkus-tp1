package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.CadastroBasicoDTO;
import br.unitins.topicos1.dto.Response.CadastroBasicoResponseDTO;
import br.unitins.topicos1.dto.Response.UsuarioResponseDTO;
import jakarta.validation.Valid;

public interface CadastroBasicoService {
    public CadastroBasicoResponseDTO create(@Valid CadastroBasicoDTO dto);
    public UsuarioResponseDTO login(String username, String senha);
}
