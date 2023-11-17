package com.csti.app.resources;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.csti.app.dtos.ListaDTO;
import com.csti.app.model.Lista;
import com.csti.app.services.ListaService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping(value = "/listas")
public class ListaResource {

	@Autowired
	private ListaService listaService;

	@GetMapping
	public ResponseEntity<List<ListaDTO>> findAll() {
		List<ListaDTO> listaDTO = listaService.findAll();
		return ResponseEntity.ok().body(listaDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ListaDTO> findById(@PathVariable Integer id) {
		ListaDTO listaDTO = listaService.findByIdDTO(id);
		return ResponseEntity.ok().body(listaDTO);
	}

	@PostMapping(value = "/{id}")
	public ResponseEntity<Lista> create(@PathVariable Integer id, @RequestBody Lista obj) {
		Lista lista = listaService.create(id, obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(lista.getId()).toUri();
		return ResponseEntity.created(uri).body(lista);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Lista> update(@PathVariable Integer id, @RequestParam(value = "equipe", defaultValue = "0") Integer idEquipe, @RequestBody Lista obj){
		Lista lista = listaService.update(id, idEquipe, obj);
		return ResponseEntity.ok().body(lista);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		listaService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
