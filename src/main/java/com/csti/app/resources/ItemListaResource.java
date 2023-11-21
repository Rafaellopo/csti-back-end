package com.csti.app.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.csti.app.dtos.ItemListaDTO;
import com.csti.app.model.ItemLista;
import com.csti.app.services.ItemListaService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping(value = "/itensLista")
public class ItemListaResource {

	@Autowired
	private ItemListaService service;

	@GetMapping
	public ResponseEntity<List<ItemListaDTO>> listItemByLista(@RequestParam(value = "identity", defaultValue = "0") Integer id) {
		List<ItemListaDTO> list = service.findAllByLista(id);

		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ItemLista> findById(@PathVariable Integer id){
		ItemLista obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping(value = "/{id}")
	public ResponseEntity<ItemLista> create(@PathVariable Integer id,
			@RequestParam(value = "people", defaultValue = "0") Integer idPessoa,
			@RequestParam(value = "locale", defaultValue = "0") Integer idCatalogo, @Valid @RequestBody ItemLista obj) {

		ItemLista objSave = service.create(id, idPessoa, idCatalogo, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(objSave.getId()).toUri();
		return ResponseEntity.created(uri).body(objSave);
	}

}
