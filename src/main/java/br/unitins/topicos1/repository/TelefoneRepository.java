package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Telefone;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TelefoneRepository implements PanacheRepository<Telefone> {

    public List<Telefone> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%"+ nome.toUpperCase() + "%").list();
    }
    
}
