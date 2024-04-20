package br.unitins.topicos1.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Genero extends DefaultEntity{
    
    @Column(length = 60, nullable = false)
    private String nome;

    @Column(length = 500, nullable = false)
    private String descricao;

    @ManyToMany(mappedBy = "listaGenero")
    private List<Livro> listaLivros;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Livro> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(List<Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
