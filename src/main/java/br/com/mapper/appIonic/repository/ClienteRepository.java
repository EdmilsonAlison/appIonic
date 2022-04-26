package br.com.mapper.appIonic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mapper.appIonic.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
