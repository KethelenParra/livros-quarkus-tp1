package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.livro.Livro;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LivroRepository implements PanacheRepository<Livro>{
    
    public List<Livro> findByTitulo(String titulo){
        return find("UPPER(titulo) LIKE ?1", "%" + titulo.toUpperCase() + "%").list();
    }

    public List<Livro> findByIsbn(String isbn){
        return find("isbn LIKE ?1", "%" + isbn + "%").list();
    }

    public List<Livro> findByDescricao(String descricao){
        return find("UPPER(descricao) LIKE ?1", "%" + descricao.toUpperCase() + "%").list();
    }

    public Livro findByTituloLivro(String nome) {
        return find("UPPER(nome) = ?1",  nome.toUpperCase() ).firstResult();
    }

}
