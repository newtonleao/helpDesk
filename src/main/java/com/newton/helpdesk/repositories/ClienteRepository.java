package com.newton.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newton.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
