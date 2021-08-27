package com.newton.helpdesk.resources;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newton.helpdesk.domain.Chamado;
import com.newton.helpdesk.domain.dtos.ChamadoDTO;
import com.newton.helpdesk.services.ChamadoService;

@RestController
@RequestMapping(value="/chamados")
public class ChamadoResource {
	
	@Autowired
	private ChamadoService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id){
		Chamado obj = service.findById(id);
		return ResponseEntity.ok().body(new ChamadoDTO(obj));
		
	}
	
	@GetMapping
	public ResponseEntity<List<ChamadoDTO>> findAll(){
		List<Chamado> obj = service.findAll();
		return ResponseEntity.ok().body(obj.stream().map((c) -> new ChamadoDTO(c)).collect(Collectors.toList()));
		
	}
	

}
