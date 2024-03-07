package br.unitins.topicos1.repository;

import java.time.LocalDate;
import java.util.List;

import br.unitins.topicos1.model.Autor;
import br.unitins.topicos1.model.Livro;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LivroRepository implements PanacheRepository<Livro>{
    
    public List<Livro> findByTitulo(String titulo){
        return find("UPPER(titulo) LIKE ?1", "%" + titulo.toUpperCase() + "%").list();
    }

    public List<Livro> findByAutor(Autor autor){
        return find("autor", autor ).list();
    }

    public List<Livro> findByEditora(String editora){
        return find("UPPER(editora) LIKE ?1", "%" + editora.toUpperCase() + "%").list();
    }

    public List<Livro> findByGenero(String genero){
        return find("UPPER(genero) LIKE ?1", "%" + genero.toUpperCase() + "%").list();
    }

    public List<Livro> findByQuantidadeEstoque(Integer quantidadeEstoque){
        return find("quantidadeEstoque = LIKE ?1", quantidadeEstoque).list();
    }

    public List<Livro> findByIsbn(String isbn){
        return find("isbn", isbn).list();
    }

    public List<Livro> findByDataLancamento(LocalDate dataLancamento){
        return find("dataLancamento = LIKE ?1", dataLancamento).list();
    }

    public List<Livro> findByDataCadastro(LocalDate dataCadastro){
        return find("dataCadastro = LIKE ?1", dataCadastro).list();
    }

    public List<Livro> findByDescricao(String descricao){
        return find("UPPER(descricao) LIKE ?1", "%" + descricao.toUpperCase() + "%").list();
    }
}
