package com.csti.app.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csti.app.model.Catalogo;
import com.csti.app.repositories.CatalogoRepository;

@Service
public class DBService {
	
	@Autowired
	private CatalogoRepository catalogoRepository;
	
	public void instanciaBase() {
		Catalogo cat = new Catalogo(null, "DIGES", "SEDE 3", "1º Andar", 105);
		Catalogo cat1 = new Catalogo(null, "DIATU", "ANEXO 1", "1º Andar", 106);
		Catalogo cat2 = new Catalogo(null, "CSTI", "ANEXO 1", "1º Andar", 105);
		Catalogo cat3 = new Catalogo(null, "COGER", "SEDE 1", "1º Andar", 103);
		Catalogo cat4 = new Catalogo(null, "NUGIT", "ANEXO 1", "3º Andar", 303);
		Catalogo cat5 = new Catalogo(null, "GAB11", "SEDE 2", "9º Andar", 903);
		Catalogo cat6 = new Catalogo(null, "NUTAQ", "SEDE 1", "Térreo", 100);
		
		this.catalogoRepository.saveAll(Arrays.asList(cat, cat1, cat2, cat3, cat4, cat5, cat6));
	}

}
