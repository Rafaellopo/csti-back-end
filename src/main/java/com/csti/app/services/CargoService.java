package com.csti.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csti.app.model.Cargo;
import com.csti.app.repositories.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;

	public List<Cargo> listAll() {
		return cargoRepository.findAll();
	}

	public Cargo findById(Integer id) {
		Optional<Cargo> cargo = cargoRepository.findById(id);

		return cargo.get();
	}

	public Cargo create(Cargo obj) {
		obj.setId(null);

		return cargoRepository.save(obj);
	}

	public Cargo update(Integer id, Cargo objCargo) {
		Cargo obj = findById(id);
		obj.setDescricao(objCargo.getDescricao());

		return cargoRepository.save(obj);
	}

	public void delete(Integer id) {
		Cargo obj = findById(id);

		if (obj != null) {
			cargoRepository.delete(obj);
		}
	}
}
