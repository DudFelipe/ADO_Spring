package br.senac.com.ado.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

public class Categoria {

    @Entity
    @Table(name = "CATEGORIA")
    public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column
        private int id;

        @NotEmpty
        @Column
        @Size(max = 25)
        private String name;

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

        //Here mappedBy indicates that the owner is in the other side
        @OneToMany(fetch = FetchType.EAGER, mappedBy = "categoria", cascade = CascadeType.ALL)
        private Set<Produto> products = new HashSet<Produto>();

    }
}
