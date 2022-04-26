package br.com.mapper.appIonic.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mapper.appIonic.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	Page<Categoria> findByNome(String nome, Pageable paginacao);

}
