package br.senac.com.ado.model;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "CATEGORIA")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDCAT")
    private int id;

    @Column(name = "nome")
    private String name;

    @ManyToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private Set<Produto> produtos;

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

