package br.unitins.topicos1.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Livro extends DefaultEntity{

    @Column(length = 60, nullable = false)
    private String titulo;

    @Column(length = 60, nullable = false)
    private Double preco;

    @Column(nullable = false)
    private Integer quantidadeEstoque;

    @Column(length = 20, nullable = false)
    private String isbn;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate dataLancamento;

    @Column(length = 5000, nullable = false)
    private String descricao;

    private Classificacao classificacao;

    @ManyToMany
    @JoinTable(
        name = "livro_autor",
        joinColumns = @JoinColumn(name = "idlivro"),
        inverseJoinColumns = @JoinColumn(name = "idautor")
    )
    private List<Autor> listaAutor;

    @ManyToMany
    @JoinTable(
        name = "livro_genero",
        joinColumns = @JoinColumn(name = "idlivro"),
        inverseJoinColumns = @JoinColumn(name = "idgenero")
    )
    private List<Genero> listaGenero;


    @ManyToOne
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Fornecedor Fornecedor;

    @ManyToOne
    @JoinColumn(name = "id_editora", nullable = false)
    private Editora Editora;


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPreco() {
        return preco;
    }


    public void setPreco(Double preco) {
        this.preco = preco;
    }


    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }


    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }


    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public LocalDate getDataLancamento() {
        return dataLancamento;
    }


    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Classificacao getClassificacao() {
        return classificacao;
    }


    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }


    public List<Autor> getListaAutor() {
        return listaAutor;
    }


    public void setListaAutor(List<Autor> listaAutor) {
        this.listaAutor = listaAutor;
    }


    public List<Genero> getListaGenero() {
        return listaGenero;
    }

    public void setListaGenero(List<Genero> listaGenero) {
        this.listaGenero = listaGenero;
    }


    public Fornecedor getFornecedor() {
        return Fornecedor;
    }


    public void setFornecedor(Fornecedor fornecedor) {
        Fornecedor = fornecedor;
    }


    public Editora getEditora() {
        return Editora;
    }


    public void setEditora(Editora editora) {
        Editora = editora;
    }

}
