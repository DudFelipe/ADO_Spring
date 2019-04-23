package br.senac.com.ado.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

public class Produto_Categoria {
    private String id_produto;
    private String id_categoria;

    public String getId_produto() {
        return id_produto;
    }

    public void setId_produto(String id_produto) {
        this.id_produto = id_produto;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    @ManyToMany
    @JoinColumn(name = "IDCAT")
    private Categoria categoria;



}


