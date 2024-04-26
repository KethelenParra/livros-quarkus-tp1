package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.ClienteResponseDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.model.Cliente;
import br.unitins.topicos1.model.Sexo;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.ClienteRepository;
import br.unitins.topicos1.repository.UsuarioRepository;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {
    
    @Inject
    public ClienteRepository clienteRepository;

    @Inject
    public UsuarioRepository usuarioRepository;


    @Override
    @Transactional
    public ClienteResponseDTO create(@Valid ClienteDTO dto){
        validarCpfCliente(dto.cpf());

        // Criar uma instância de Usuario com os dados do clienteDTO
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setSenha(dto.senha());
        usuario.setDataNascimento(dto.dataNascimento());
        usuario.setEmail(dto.email());
        usuario.setCpf(dto.cpf());
        usuario.setSexo(Sexo.valueOf(dto.idSexo()));
        usuario.setTelefone(TelefoneDTO.convertToTelefone(dto.telefone()));

        // Persistir o Usuario no banco de dados antes de associá-lo ao cliente
        usuarioRepository.persist(usuario);

        // Criar uma instância de Funcionario com os dados do clienteDTO
        Cliente cliente = new Cliente();
        cliente.setEndereco(dto.endereco());
        cliente.setCep(dto.cep());
        cliente.setCidade(dto.cidade());
        cliente.setEstado(dto.estado());
        cliente.setUsuario(usuario); // Agora o Usuario está persistido e pode ser associado ao cliente

        clienteRepository.persist(cliente);
        return ClienteResponseDTO.valueOf(cliente);
    }

    public void validarCpfCliente(String cpf){
        Usuario cliente = usuarioRepository.findByCpfUsuario(cpf);
        if (cliente != null)
        throw  new ValidationException("cpf", "O CPF: '"+ cpf +"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, ClienteDTO dto){
        Cliente clienteBanco = clienteRepository.findById(id);
        clienteBanco.setEndereco(dto.endereco());
        clienteBanco.setCep(dto.cep());
        clienteBanco.setCidade(dto.cidade());
        clienteBanco.setEstado(dto.estado());
            
        // Criar uma instância de Usuario com os dados do clienteDTO
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setSenha(dto.senha());
        usuario.setDataNascimento(dto.dataNascimento());
        usuario.setEmail(dto.email());
        usuario.setCpf(dto.cpf());
        usuario.setSexo(Sexo.valueOf(dto.idSexo()));
        usuario.setTelefone(TelefoneDTO.convertToTelefone(dto.telefone()));
    
        clienteBanco.setUsuario(usuario);
        usuarioRepository.persist(usuario);
    }

    @Override
    @Transactional
    public void delete(Long id){
        clienteRepository.deleteById(id);
    }

    @Override
    public ClienteResponseDTO findById(Long id){
        return ClienteResponseDTO.valueOf(clienteRepository.findById(id));
    }

    @GET
    public List<ClienteResponseDTO> findAll(){
        return clienteRepository.listAll().stream().map(a -> ClienteResponseDTO.valueOf(a)).toList();
    }

    @Override
    public List<ClienteResponseDTO> findByEstado(String estado) {
        return clienteRepository.findByEstado(estado).stream().map(clientes -> ClienteResponseDTO.valueOf(clientes)).toList();
    }

    @Override
    public List<UsuarioResponseDTO> findByCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf).stream().map(c -> UsuarioResponseDTO.valueOf(c)).toList();
    }
}

