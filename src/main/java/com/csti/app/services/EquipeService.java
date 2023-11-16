package com.csti.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csti.app.model.Equipe;
import com.csti.app.repositories.EquipeRepository;

@Service
public class EquipeService {

	@Autowired
	private EquipeRepository equipeRepository;

	public List<Equipe> listAll() {
		return equipeRepository.findAll();
	}

	public Equipe findById(Integer id) {
		Optional<Equipe> list = equipeRepository.findById(id);
		return list.get();
	}

	public Equipe create(Equipe equipe) {
		equipe.setId(null);
		return equipeRepository.save(equipe);
	}
	
	public Equipe update(Integer id, Equipe equipe) {
		Equipe obj = findById(id);
		obj.setDescricao(equipe.getDescricao());
		return equipeRepository.save(obj);
	}
	
	public void delete(Integer id) {
		Equipe equipe = findById(id);
		if(equipe != null) {
			equipeRepository.delete(equipe);
		}
	}
}
