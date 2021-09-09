package com.newton.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.newton.helpdesk.domain.Chamado;
import com.newton.helpdesk.domain.Cliente;
import com.newton.helpdesk.domain.Tecnico;
import com.newton.helpdesk.domain.enums.Perfil;
import com.newton.helpdesk.domain.enums.Prioridade;
import com.newton.helpdesk.domain.enums.Status;
import com.newton.helpdesk.repositories.ChamadoRepository;
import com.newton.helpdesk.repositories.ClienteRepository;
import com.newton.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	TecnicoRepository tecnicoRepository;
	@Autowired
	ChamadoRepository chamadoRepository;
	@Autowired
	private BCryptPasswordEncoder enconder;
	
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "valdir Cezar","91337292044","valdir@email.com",enconder.encode("123"));
		tec1.addPerfis(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "tecnico 2","94402110084","tec2@email.com",enconder.encode("123"));
		Tecnico tec3 = new Tecnico(null, "tecnico 3","89819198011","tec3@email.com",enconder.encode("123"));
		Tecnico tec4 = new Tecnico(null, "tecnico 4","45424659004","tec4@email.com",enconder.encode("123"));
		
		Cliente cli1 = new Cliente(null, "newton", "51392488591", "newton@email.com", enconder.encode("123"));
		Cliente cli2 = new Cliente(null, "cliente 2", "92238715061", "cli2@email.com", enconder.encode("123"));
		Cliente cli3 = new Cliente(null, "cliente 3", "37066336046", "cli3@email.com", enconder.encode("123"));
		Cliente cli4 = new Cliente(null, "cliente 4", "56262910085", "cli4@email.com", enconder.encode("123"));
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "chamado 01", "primeiro chamado", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "chamado 02", "segundo chamado", tec2, cli2);
		
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4));
		tecnicoRepository.saveAll(Arrays.asList(tec1,tec2,tec3,tec4));
		chamadoRepository.saveAll(Arrays.asList(c1,c2));
	}

}
