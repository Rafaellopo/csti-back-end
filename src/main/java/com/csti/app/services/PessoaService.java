package com.csti.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csti.app.model.Cargo;
import com.csti.app.model.Equipe;
import com.csti.app.model.Pessoa;
import com.csti.app.model.Status;
import com.csti.app.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private StatusService statusService;
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private EquipeService equipeService;

	public Pessoa findById(Integer id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		return pessoa.get();

	}

	public List<Pessoa> listAll() {
		return pessoaRepository.findAll();
	}

	public Pessoa create(Integer id_status, Integer id_cargo, Integer id_equipe, Pessoa pessoa) {
		pessoa.setId(null);
		Status status = statusService.findById(id_status);
		Cargo cargo = cargoService.findById(id_cargo);
		Equipe equipe = equipeService.findById(id_equipe);
		pessoa.setStatus(status);
		pessoa.setCargo(cargo);
		pessoa.setEquipe(equipe);
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa update(Integer id, Integer idStatus, Integer idCargo, Integer idEquipe, Pessoa pessoaObj) {
		Pessoa obj = findById(id);
		Status status = statusService.findById(idStatus);
		Cargo cargo = cargoService.findById(idCargo);
		Equipe equipe = equipeService.findById(idEquipe);
		obj.setNome(pessoaObj.getNome());
		obj.setStatus(status);
		obj.setCargo(cargo);
		obj.setEquipe(equipe);
		return this.pessoaRepository.save(obj);
	}
	
	
	public void delete(Integer id) {
		Pessoa pessoa = findById(id);
		if(pessoa != null) {
			pessoaRepository.delete(pessoa);
		}
	}

}
