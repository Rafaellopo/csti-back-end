package com.csti.app.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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

import com.csti.app.model.Catalogo;
import com.csti.app.services.CatalogoService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping(value = "/catalogo")
public class CatalogoResource {

	@Autowired
	private CatalogoService service;

	@GetMapping
	public ResponseEntity<List<Catalogo>> listAll() {
		List<Catalogo> listObj = service.findAll();
		return ResponseEntity.ok().body(listObj);
	}

	@GetMapping(value = "/setor/{setor}")
	public ResponseEntity<List<Catalogo>> listAllBySetor(@PathVariable String setor) {
		List<Catalogo> listObjs = service.findAllBySetor(setor);
		return ResponseEntity.ok().body(listObjs);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Catalogo> findById(@PathVariable Integer id) {
		Catalogo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Catalogo> createCatalogo(@Valid @RequestBody Catalogo obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Catalogo> update(@PathVariable Integer id, @RequestBody Catalogo objCatalogo) {
		objCatalogo = service.update(id, objCatalogo);
		return ResponseEntity.ok().body(objCatalogo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
