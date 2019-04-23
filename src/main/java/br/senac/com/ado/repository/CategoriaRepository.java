package br.senac.com.ado.repository;

import br.senac.com.ado.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
