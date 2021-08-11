package com.newton.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.newton.helpdesk.domain.Chamado;
import com.newton.helpdesk.domain.Cliente;
import com.newton.helpdesk.domain.Tecnico;
import com.newton.helpdesk.domain.enums.Perfil;
import com.newton.helpdesk.domain.enums.Prioridade;
import com.newton.helpdesk.domain.enums.Status;
import com.newton.helpdesk.repositories.ChamadoRepository;
import com.newton.helpdesk.repositories.ClienteRepository;
import com.newton.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner{
	
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	TecnicoRepository tecnicoRepository;
	@Autowired
	ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Tecnico tec1 = new Tecnico(null, "valdir Cezar","91337292044","valdir@email.com","123");
		tec1.addPerfis(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "newton", "51392488591", "newton@email.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "chamado 01", "primeiro chamado", tec1, cli1);
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
	}

}
