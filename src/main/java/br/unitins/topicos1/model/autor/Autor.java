package br.unitins.topicos1.model.autor;

import java.util.List;

import br.unitins.topicos1.model.defaultEntity.DefaultEntity;
import br.unitins.topicos1.model.livro.Livro;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Autor extends DefaultEntity{
        
    @Column(length = 60, nullable = false)
    private String nome;

    @Column(length = 10000, nullable = false)
    private String biografia;

    @ManyToMany(mappedBy = "listaAutor")
    private List<Livro> listaLivros;

    private String nomeImagem;

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public List<Livro> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(List<Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }
}
