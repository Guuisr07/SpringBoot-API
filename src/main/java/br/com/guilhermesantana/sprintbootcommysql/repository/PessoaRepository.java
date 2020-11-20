package br.com.guilhermesantana.sprintbootcommysql.repository;

import br.com.guilhermesantana.sprintbootcommysql.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
