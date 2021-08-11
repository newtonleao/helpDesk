package com.newton.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newton.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
