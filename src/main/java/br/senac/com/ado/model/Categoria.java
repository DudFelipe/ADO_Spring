package br.senac.com.ado.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "CATEGORIA")
public class Categoria {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column
        private int id;


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

        @OneToMany(cascade=CascadeType.ALL, mappedBy="categoria")
        private Set<Categoria> categoria;
}

