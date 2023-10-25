package com.csti.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csti.app.model.Pessoa;
import com.csti.app.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> listAll() {
		return pessoaRepository.findAll();
	}

	public Pessoa create(Pessoa pessoa) {
		pessoa.setId(null);
		return pessoaRepository.save(pessoa);
	}

	public Pessoa findById(Integer id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		return pessoa.get();

	}

	public Pessoa update(Integer id, Pessoa pessoaObj) {
		Pessoa obj = findById(id);
		obj.setCargo(pessoaObj.getCargo());
		obj.setEquipe(pessoaObj.getEquipe());
		obj.setNome(pessoaObj.getNome());
		obj.setStatus(pessoaObj.getStatus());
		return this.pessoaRepository.save(obj);
	}
	
	
	public void delete(Integer id) {
		Pessoa pessoa = findById(id);
		if(pessoa != null) {
			pessoaRepository.delete(pessoa);
		}
	}

}
