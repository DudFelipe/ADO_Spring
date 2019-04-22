package br.senac.com.ado.model;

import javax.persistence.*;



@Entity
@Table(name = "CATEGORIA")
public class Categoria {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "IDCAT")
        private int id;

        @Column(name = "NOME")
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

}

