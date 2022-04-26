package br.com.mapper.appIonic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mapper.appIonic.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
