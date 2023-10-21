package com.csti.app.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.csti.app.model.Pessoa;
import com.csti.app.services.PessoaService;


@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping(value = "")
	public ResponseEntity<List<Pessoa>> listAll() {
		List<Pessoa> listPessoa = pessoaService.listAll();

		return ResponseEntity.ok().body(listPessoa);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa pessoa){
		pessoa = pessoaService.create(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(pessoa.getId()).toUri();
		
		return ResponseEntity.created(uri).body(pessoa);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Integer id){
		Pessoa pessoa = pessoaService.findById(id);
		return ResponseEntity.ok().body(pessoa);
	}
}
