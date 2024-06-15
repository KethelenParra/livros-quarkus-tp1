package br.unitins.topicos1.service.serviceImpl;

import br.unitins.topicos1.dto.CadastroBasicoDTO;
import br.unitins.topicos1.dto.Response.CadastroBasicoResponseDTO;
import br.unitins.topicos1.dto.Response.UsuarioResponseDTO;
import br.unitins.topicos1.model.Enum.Sexo;
import br.unitins.topicos1.model.Pessoa.Cliente;
import br.unitins.topicos1.model.Pessoa.Usuario;
import br.unitins.topicos1.repository.pessoa.ClienteRepository;
import br.unitins.topicos1.repository.pessoa.UsuarioRepository;
import br.unitins.topicos1.service.CadastroBasicoService;
import br.unitins.topicos1.service.hash.HashService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class CadastroBasicoServiceImpl implements CadastroBasicoService {

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    HashService hashService;

    @Override
   @Transactional
    public CadastroBasicoResponseDTO create(@Valid CadastroBasicoDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setUsername(dto.username());
        usuario.setSenha(hashService.getHashSenha(dto.senha()));
        usuario.setSexo(Sexo.valueOf(dto.idSexo()));

        usuarioRepository.persist(usuario);

        Cliente cliente = new Cliente();
        cliente.setUsuario(usuario);

        clienteRepository.persist(cliente);
        return CadastroBasicoResponseDTO.valueOf(cliente);
    }

    @Override
    public UsuarioResponseDTO login(String username, String senha) {
        Cliente cliente = clienteRepository.findByUsernameAndSenha(username, senha);
        return UsuarioResponseDTO.valueOf(cliente.getUsuario());
    }
    
}
