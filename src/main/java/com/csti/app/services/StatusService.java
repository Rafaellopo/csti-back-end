package com.csti.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csti.app.dtos.StatusDTO;
import com.csti.app.model.Status;
import com.csti.app.repositories.StatusRepository;

@Service
public class StatusService {

	@Autowired
	private StatusRepository statusRepositoty;
	
	public Status findById(Integer id) {
		Optional<Status> obj = statusRepositoty.findById(id);
		
		return obj.get();
	}
	
	public List<Status> findAll(){
		return statusRepositoty.findAll();
	}
	
	public Status create(Status obj) {
		obj.setId(null);
		return statusRepositoty.save(obj);
	}
	
	public Status create(Integer id, StatusDTO statusDTO) {
		Status obj = findById(id);
		obj.setDescricao(null);
		
		return statusRepositoty.save(obj);
	}
	
	public void delete(Integer id) {
		Status obj = findById(id);
		if(obj != null) {
			statusRepositoty.deleteById(id);
		}
	}
	
	
	
	
	
	
	
	
	
}
