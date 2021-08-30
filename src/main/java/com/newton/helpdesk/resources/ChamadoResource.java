package com.newton.helpdesk.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.newton.helpdesk.domain.Chamado;
import com.newton.helpdesk.domain.dtos.ChamadoDTO;
import com.newton.helpdesk.services.ChamadoService;

@RestController
@RequestMapping(value = "/chamados")
public class ChamadoResource {

	@Autowired
	private ChamadoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id) {
		Chamado obj = service.findById(id);
		return ResponseEntity.ok().body(new ChamadoDTO(obj));

	}

	@GetMapping
	public ResponseEntity<List<ChamadoDTO>> findAll() {
		List<Chamado> obj = service.findAll();
		return ResponseEntity.ok().body(obj.stream().map((c) -> new ChamadoDTO(c)).collect(Collectors.toList()));

	}

	@PostMapping
	public ResponseEntity<ChamadoDTO> create(@Valid @RequestBody ChamadoDTO objDTO) {
		Chamado obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
