package com.csti.app.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.csti.app.dtos.EquipeDTO;
import com.csti.app.model.Equipe;
import com.csti.app.services.EquipeService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping(value = "/equipe")
public class EquipeResource {

	@Autowired
	private EquipeService equipeService;

	@GetMapping
	public ResponseEntity<List<EquipeDTO>> listAll() {
		List<Equipe> list = equipeService.listAll();
		List<EquipeDTO> listDTO = list.stream().map(obj -> new EquipeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Equipe> findById(@PathVariable Integer id) {
		Equipe equipe = equipeService.findById(id);
		return ResponseEntity.ok().body(equipe);
	}

	@PostMapping
	public ResponseEntity<Equipe> create(@RequestBody Equipe equipe) {
		Equipe obj = equipeService.create(equipe);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Equipe> update(@PathVariable Integer id, @RequestBody Equipe equipe) {
		Equipe obj = equipeService.update(id, equipe);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		equipeService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
