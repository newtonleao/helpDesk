package com.newton.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newton.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
