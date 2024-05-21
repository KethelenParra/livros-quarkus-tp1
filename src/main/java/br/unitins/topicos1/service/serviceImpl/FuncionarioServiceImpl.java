package br.unitins.topicos1.service.serviceImpl;

import java.util.List;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.Response.FuncionarioResponseDTO;
import br.unitins.topicos1.dto.Response.UsuarioResponseDTO;
import br.unitins.topicos1.model.Enum.Sexo;
import br.unitins.topicos1.model.Pessoa.Funcionario;
import br.unitins.topicos1.model.Pessoa.Usuario;
import br.unitins.topicos1.repository.pessoa.FuncionarioRepository;
import br.unitins.topicos1.repository.pessoa.UsuarioRepository;
import br.unitins.topicos1.service.FuncionarioService;
import br.unitins.topicos1.service.hash.HashService;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class FuncionarioServiceImpl implements FuncionarioService {

    @Inject
    public FuncionarioRepository funcionarioRepository;

    @Inject
    public UsuarioRepository usuarioRepository;

    @Inject
    public HashService hashService;

    @Override
    @Transactional
    public FuncionarioResponseDTO create(@Valid FuncionarioDTO dto) {
        validarCpfFuncionario(dto.cpf());

        // Criar uma instância de Usuario com os dados do FuncionarioDTO
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setUsername(dto.username());
        usuario.setSenha(hashService.getHashSenha(dto.senha())); // gerando o hash da senha
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
        funcionario.setUsuario(usuario);

        // Persistir o Funcionario no banco de dados
        funcionarioRepository.persist(funcionario);

        // Retornar uma representação do funcionário criado
        return FuncionarioResponseDTO.valueOf(funcionario);
    }

    public void validarCpfFuncionario(String cpf) {
        Usuario funcionario = usuarioRepository.findByCpfUsuario(cpf);
        if (funcionario != null)
            throw new ValidationException("cpf", "O  CPF: '" + cpf + "' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, FuncionarioDTO dto) {
        Funcionario funcionarioBanco = funcionarioRepository.findById(id);
        if (funcionarioBanco == null) {
            throw new NotFoundException("Funcionário não encontrado");
        }

        // Atualiza os dados do funcionário
        funcionarioBanco.setCargo(dto.cargo());
        funcionarioBanco.setSalario(dto.salario());

        // Atualiza os dados do usuário associado ao funcionário
        Usuario usuario = funcionarioBanco.getUsuario();
        usuario.setNome(dto.nome());
        usuario.setUsername(dto.username());
        usuario.setSenha(hashService.getHashSenha(dto.senha()));
        usuario.setDataNascimento(dto.dataNascimento());
        usuario.setEmail(dto.email());
        usuario.setCpf(dto.cpf());
        usuario.setSexo(Sexo.valueOf(dto.idSexo()));
        usuario.setTelefone(TelefoneDTO.convertToTelefone(dto.telefone()));

        // Não é necessário persistir o usuário novamente, pois ele já está no banco de
        // dados
    }

    @Override
    @Transactional
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    @Override
    public FuncionarioResponseDTO findById(Long id) {
        return FuncionarioResponseDTO.valueOf(funcionarioRepository.findById(id));
    }

    @GET
    public List<FuncionarioResponseDTO> findAll() {
        return funcionarioRepository.listAll().stream().map(a -> FuncionarioResponseDTO.valueOf(a)).toList();
    }

    @Override
    public List<FuncionarioResponseDTO> findByCargo(String cargo) {
        return funcionarioRepository.findByCargo(cargo).stream()
                .map(funcionario -> FuncionarioResponseDTO.valueOf(funcionario)).toList();
    }

    @Override
    public List<UsuarioResponseDTO> findByCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf).stream().map(c -> UsuarioResponseDTO.valueOf(c)).toList();
    }

    @Override
    public UsuarioResponseDTO login(String username, String senha) {
        Funcionario funcionario = funcionarioRepository.findByUsernameAndSenha(username, senha);
        return UsuarioResponseDTO.valueOf(funcionario.getUsuario());
    }
}
