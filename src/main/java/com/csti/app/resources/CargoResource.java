package com.csti.app.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.csti.app.dtos.CargoDTO;
import com.csti.app.model.Cargo;
import com.csti.app.services.CargoService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping(value = "/cargo")
public class CargoResource {

	@Autowired
	private CargoService cargoService;

	@GetMapping
	public ResponseEntity<List<CargoDTO>> findAll() {
		List<Cargo> list = cargoService.listAll();
		List<CargoDTO> listDTO = list.stream().map(obj -> new CargoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cargo> findById(@PathVariable Integer id) {
		Cargo obj = cargoService.findById(id);

		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Cargo> create(@RequestBody Cargo cargo) {
		Cargo obj = cargoService.create(cargo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cargo> update(@PathVariable Integer id, @RequestBody Cargo obj) {
		Cargo cargo = cargoService.update(id, obj);

		return ResponseEntity.ok().build();
	}
}
