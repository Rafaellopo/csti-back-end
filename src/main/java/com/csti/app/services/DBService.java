package com.csti.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csti.app.model.Catalogo;
import com.csti.app.repositories.CatalogoRepository;

@Service
public class DBService {
	
	@Autowired
	private CatalogoRepository catalogoRepository;
	
	public void instanciaBase() {
		Catalogo cat = new Catalogo(null, "DIGES", "SEDE 3", "1º Andar", 103);
		
		this.catalogoRepository.save(cat);
	}

}
