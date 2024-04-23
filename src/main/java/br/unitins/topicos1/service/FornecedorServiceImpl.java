package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.FornecedorDTO;
import br.unitins.topicos1.dto.FornecedorResponseDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.model.Fornecedor;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.repository.FornecedorRepository;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class FornecedorServiceImpl implements FornecedorService {

    @Inject
    public FornecedorRepository fornecedorRepository;

    @Override
    @Transactional
    public FornecedorResponseDTO create(@Valid FornecedorDTO dto) {
        validarNomeFornecedor(dto.nome());

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(dto.nome());
        fornecedor.setCnpj(dto.cnpj());
        fornecedor.setInscricaoEstadual(dto.inscricaoEstadual());
        fornecedor.setEmail(dto.email());
        fornecedor.setEndereco(dto.endereco());
        fornecedor.setCep(dto.cep());
        fornecedor.setEstado(dto.estado());
        fornecedor.setCidade(dto.cidade());
        fornecedor.setQuantLivrosFornecido(dto.quantLivrosFornecido());

        TelefoneDTO telefoneDTO = dto.telefone(); // Armazena o DTO do telefone
        if (telefoneDTO != null) { // Verifica se o DTO do telefone não é nulo
            Telefone telefone = new Telefone();
            telefone.setCodigoArea(telefoneDTO.codigoArea());
            telefone.setNumero(telefoneDTO.numero());
            fornecedor.setTelefone(telefone);
        }

        fornecedorRepository.persist(fornecedor);
        return FornecedorResponseDTO.valueOf(fornecedor);
    }
    public void validarNomeFornecedor(String nome) {
        Fornecedor fornecedor = fornecedorRepository.findByNomeFornecedor(nome);
        if (fornecedor != null)
            throw  new ValidationException("nome", "O fornecedor '"+nome+"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, FornecedorDTO dto) {
        Fornecedor fornecedorBanco = fornecedorRepository.findById(id);

        fornecedorBanco.setNome(dto.nome());
        fornecedorBanco.setCnpj(dto.cnpj());
        fornecedorBanco.setInscricaoEstadual(dto.inscricaoEstadual());
        fornecedorBanco.setEmail(dto.email());
        fornecedorBanco.setEndereco(dto.endereco());
        fornecedorBanco.setCep(dto.cep());
        fornecedorBanco.setEstado(dto.estado());
        fornecedorBanco.setCidade(dto.cidade());
        fornecedorBanco.setQuantLivrosFornecido(dto.quantLivrosFornecido());

        Telefone telefone = new Telefone();
        telefone.setCodigoArea(dto.telefone().codigoArea());
        telefone.setNumero(dto.telefone().numero());
        fornecedorBanco.setTelefone(telefone);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        fornecedorRepository.deleteById(id);
    }

    @Override
    public FornecedorResponseDTO findById(Long id) {
        return FornecedorResponseDTO.valueOf(fornecedorRepository.findById(id));
    }

    @Override
    public List<FornecedorResponseDTO> findAll() {
        return fornecedorRepository.listAll().stream().map(fornecedores -> FornecedorResponseDTO.valueOf(fornecedores)).toList();
    }

    @Override
    public List<FornecedorResponseDTO> findByNome(String nome) {
        return fornecedorRepository.findByNome(nome).stream().map(fornecedores -> FornecedorResponseDTO.valueOf(fornecedores)).toList();
    }

    @Override
    public List<FornecedorResponseDTO> findByCidade(String cidade) {
        return fornecedorRepository.findByCidade(cidade).stream().map(fornecedores -> FornecedorResponseDTO.valueOf(fornecedores)).toList();
    }

    @Override
    public List<FornecedorResponseDTO> findByEstado(String estado) {
        return fornecedorRepository.findByEstado(estado).stream().map(fornecedores -> FornecedorResponseDTO.valueOf(fornecedores)).toList();
    }
    
}
