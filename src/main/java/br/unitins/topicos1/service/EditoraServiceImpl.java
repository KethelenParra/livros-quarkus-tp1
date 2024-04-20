package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.EditoraDTO;
import br.unitins.topicos1.dto.EditoraResponseDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.model.Editora;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.repository.EditoraRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class EditoraServiceImpl implements EditoraService {

    @Inject
    public EditoraRepository editoraRepository;

    @Override
    @Transactional
    public EditoraResponseDTO create(@Valid EditoraDTO dto) {
        Editora editora = new Editora();
        editora.setNome(dto.nome());
        editora.setEmail(dto.email());
        editora.setEndereco(dto.endereco());
        editora.setEndereco(dto.endereco());
        editora.setEstado(dto.estado());

        TelefoneDTO telefoneDTO = dto.telefone(); // Armazena o DTO do telefone
        if (telefoneDTO != null) { // Verifica se o DTO do telefone não é nulo
            Telefone telefone = new Telefone();
            telefone.setCodigoArea(telefoneDTO.codigoArea());
            telefone.setNumero(telefoneDTO.numero());
            editora.setTelefone(telefone);
        }
        
        editoraRepository.persist(editora);
        return EditoraResponseDTO.valueOf(editora);
    }

    @Override
    @Transactional
    public void update(Long id, EditoraDTO dto) {
        Editora editoraBanco = editoraRepository.findById(id);

        editoraBanco.setNome(dto.nome());
        editoraBanco.setEmail(dto.email());
        editoraBanco.setEndereco(dto.endereco());
        editoraBanco.setEndereco(dto.endereco());
        editoraBanco.setEstado(dto.estado());

        Telefone telefone = new Telefone();
        telefone.setCodigoArea(dto.telefone().codigoArea());
        telefone.setNumero(dto.telefone().numero());
        editoraBanco.setTelefone(telefone);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        editoraRepository.deleteById(id);
    }

    @Override
    public EditoraResponseDTO findById(Long id) {
        return EditoraResponseDTO.valueOf(editoraRepository.findById(id));
    }

    @Override
    public List<EditoraResponseDTO> findAll() {
        return editoraRepository.listAll().stream().map(editoraes -> EditoraResponseDTO.valueOf(editoraes)).toList();
    }

    @Override
    public List<EditoraResponseDTO> findByNome(String nome) {
        return editoraRepository.findByNome(nome).stream().map(editoraes -> EditoraResponseDTO.valueOf(editoraes)).toList();
    }

    @Override
    public List<EditoraResponseDTO> findByEstado(String estado) {
        return editoraRepository.findByEstado(estado).stream().map(editoraes -> EditoraResponseDTO.valueOf(editoraes)).toList();
    }

}
