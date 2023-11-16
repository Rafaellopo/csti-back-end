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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.csti.app.dtos.StatusDTO;
import com.csti.app.model.Status;
import com.csti.app.services.StatusService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping(value = "/status")
public class StatusResource {
	
	@Autowired
	private StatusService statusService;
	
	@GetMapping
	public ResponseEntity<List<StatusDTO>> findAll(){
		List<Status> list  = statusService.findAll();
		List<StatusDTO> listDTO = list.stream().map(obj -> new StatusDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Status> findById(@PathVariable Integer id){
		Status status = statusService.findById(id);
		return ResponseEntity.ok().body(status);
	}
	
	@PostMapping
	public ResponseEntity<Status> create(@Valid @RequestBody Status obj){
		obj = statusService.create(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StatusDTO> update(@PathVariable Integer id, @RequestBody StatusDTO objDTO){
		Status newObj = statusService.create(id, objDTO);
		
		return ResponseEntity.ok().body(new StatusDTO(newObj));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		statusService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
