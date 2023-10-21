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
	
	public Pessoa findById(Integer id){
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		return pessoa.get();
		
	}

}
