package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.FuncionarioResponseDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.model.Funcionario;
import br.unitins.topicos1.model.Sexo;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.FuncionarioRepository;
import br.unitins.topicos1.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;

@ApplicationScoped
public class FuncionarioServiceImpl implements FuncionarioService {
    
    @Inject
    public FuncionarioRepository funcionarioRepository;

    @Inject
    public UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto){

         // Criar uma instância de Usuario com os dados do FuncionarioDTO
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setSenha(dto.senha());
        usuario.setDataNascimento(dto.dataNascimento());
        usuario.setEmail(dto.email());
        usuario.setCpf(dto.cpf());
        usuario.setSexo(Sexo.valueOf(dto.idSexo()));
        usuario.setTelefone(TelefoneDTO.convertToTelefone(dto.telefone()));

        // Persistir o Usuario no banco de dados antes de associá-lo ao Funcionario
        usuarioRepository.persist(usuario);

        // Criar uma instância de Funcionario com os dados do FuncionarioDTO
        Funcionario funcionario = new Funcionario();
        funcionario.setCargo(dto.cargo());
        funcionario.setSalario(dto.salario());
        funcionario.setUsuario(usuario); // Agora o Usuario está persistido e pode ser associado ao Funcionario

        // Persistir o Funcionario no banco de dados
        funcionarioRepository.persist(funcionario);

        // Retornar uma representação do funcionário criado
        return FuncionarioResponseDTO.valueOf(funcionario);
    }

    @Override
    @Transactional
    public void update(Long id, FuncionarioDTO dto){
        Funcionario funcionarioBanco = funcionarioRepository.findById(id);
        funcionarioBanco.setCargo(dto.cargo());
        funcionarioBanco.setSalario(dto.salario());

         // Criar uma instância de Usuario com os dados do FuncionarioDTO
        Usuario usuario =  funcionarioBanco.getUsuario();
        usuario.setNome(dto.nome());
        usuario.setSenha(dto.senha());
        usuario.setDataNascimento(dto.dataNascimento());
        usuario.setEmail(dto.email());
        usuario.setCpf(dto.cpf());
        usuario.setSexo(Sexo.valueOf(dto.idSexo()));
        usuario.setTelefone(TelefoneDTO.convertToTelefone(dto.telefone()));
    }

    @Override
    @Transactional
    public void delete(Long id){
        funcionarioRepository.deleteById(id);
    }

    @Override
    public FuncionarioResponseDTO findById(Long id){
        return FuncionarioResponseDTO.valueOf(funcionarioRepository.findById(id));
    }

    @GET
    public List<FuncionarioResponseDTO> findAll(){
        return funcionarioRepository.listAll().stream().map(a -> FuncionarioResponseDTO.valueOf(a)).toList();
    }

    @Override
    public List<FuncionarioResponseDTO> findByCargo(String cargo) {
        return funcionarioRepository.findByCargo(cargo).stream().map(funcionario -> FuncionarioResponseDTO.valueOf(funcionario)).toList();
    }
    
    @Override
    public List<UsuarioResponseDTO> findByCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf).stream().map(c -> UsuarioResponseDTO.valueOf(c)).toList();
    }
}

