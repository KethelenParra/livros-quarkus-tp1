package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.AutorDTO;
import br.unitins.topicos1.dto.AutorResponseDTO;
import br.unitins.topicos1.model.Autor;
import br.unitins.topicos1.repository.AutorRepository;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class AutorServiceImpl implements AutorService{

    @Inject
    public AutorRepository autorRepository;

    @Override
    @Transactional
    public AutorResponseDTO create(@Valid AutorDTO dto){
        validarNomeCompletoAutor(dto.nome());

        Autor autor = new Autor();
        autor.setNome(dto.nome());
        autor.setBiografia(dto.biografia());

        autorRepository.persist(autor);
        return AutorResponseDTO.valueOf(autor);
    }

    public void validarNomeCompletoAutor(String nome) {
        Autor autor = autorRepository.findByNomeCompleto(nome);
        if (autor != null)
            throw  new ValidationException("nome", "O nome '"+nome+"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, AutorDTO dto){
        Autor autorBanco = autorRepository.findById(id);

        autorBanco.setNome(dto.nome());
        autorBanco.setBiografia(dto.biografia());
    }

    @Override
    @Transactional
    public void delete(Long id){
        autorRepository.deleteById(id);
    }

    @Override
    public AutorResponseDTO findById(Long id){
        return AutorResponseDTO.valueOf(autorRepository.findById(id));
    }

    @Override
    public List<AutorResponseDTO> findAll(){
        return autorRepository.listAll().stream().map(autor -> AutorResponseDTO.valueOf(autor)).toList();
    }

    @Override
    public List<AutorResponseDTO> findByNome(String nome){
        return autorRepository.findByNome(nome).stream().map(autor -> AutorResponseDTO.valueOf(autor)).toList();
    }

    @Override
    public List<AutorResponseDTO> findByBiografia(String biografia){
        return autorRepository.findByBiografia(biografia).stream().map(autor -> AutorResponseDTO.valueOf(autor)).toList();
    }

}
