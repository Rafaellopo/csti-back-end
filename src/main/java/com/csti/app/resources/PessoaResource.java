package com.csti.app.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.csti.app.dtos.PessoaDTO;
import com.csti.app.model.Pessoa;
import com.csti.app.services.PessoaService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping()
	public ResponseEntity<List<PessoaDTO>> listAll() {
		List<Pessoa> list = pessoaService.listAll();
		List<PessoaDTO> listDTO = list.stream().map(obj -> new PessoaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PessoaDTO> findById(@PathVariable Integer id) {
		Pessoa pessoa = pessoaService.findById(id);
		PessoaDTO pessoaDTO = new PessoaDTO(pessoa);
		return ResponseEntity.ok().body(pessoaDTO);
	}


	@PostMapping
	public ResponseEntity<Pessoa> createPessoa(@RequestParam(value = "status", defaultValue = "0") Integer id_status,
			@RequestParam(value = "cargo", defaultValue = "0") Integer id_cargo,
			@RequestParam(value = "equipe", defaultValue = "0") Integer id_equipe, @Valid @RequestBody Pessoa pessoa) {
		pessoa = pessoaService.create(id_status, id_cargo, id_equipe, pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(pessoa.getId()).toUri();

		return ResponseEntity.created(uri).body(pessoa);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Integer id, @RequestParam(value = "status", defaultValue = "0") Integer idStatus, @RequestParam(value = "cargo", defaultValue = "0") Integer idCargo, @RequestParam(value = "equipe", defaultValue = "0") Integer idEquipe, @Valid @RequestBody Pessoa pessoaObj) {
		Pessoa pessoa = pessoaService.update(id,idStatus, idCargo, idEquipe, pessoaObj);
		return ResponseEntity.ok().body(pessoa);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		pessoaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
