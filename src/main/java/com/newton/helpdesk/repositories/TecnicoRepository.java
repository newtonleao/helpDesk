package com.newton.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newton.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
