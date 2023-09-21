package com.csti.resources;

import java.net.URI;

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

import com.csti.model.Catalogo;
import com.csti.services.CatalogoService;

@RestController
@RequestMapping(value = "/catalogo")
public class CatalogoResource {
	
	@Autowired
	private CatalogoService service;
	
	@GetMapping(value = "/id")
	public ResponseEntity<Catalogo> findById(@PathVariable Integer id){
		Catalogo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Catalogo> createCatalogo(@Valid @RequestBody Catalogo obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}
