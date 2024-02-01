package com.csti.app.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csti.app.dtos.ItemListaDTO;
import com.csti.app.model.Catalogo;
import com.csti.app.model.ItemLista;
import com.csti.app.model.Lista;
import com.csti.app.model.Pessoa;
import com.csti.app.repositories.CatalogoRepository;
import com.csti.app.repositories.ItemListaRepository;
import com.csti.app.repositories.ListaRepository;
import com.csti.app.repositories.PessoaRepository;

@Service
public class ItemListaService {

	@Autowired
	private ItemListaRepository repository;

	@Autowired
	private ListaRepository listaRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private CatalogoRepository catalogoRepository;

	public List<ItemListaDTO> findAllByLista(Integer id) {
		Optional<Lista> lista = listaRepository.findById(id);

		List<ItemLista> itemLista = repository.findAllByLista(lista.get());

		List<ItemListaDTO> itemListaDTO = itemLista.stream().map(obj -> new ItemListaDTO(obj))
				.collect(Collectors.toList());
		return itemListaDTO;

	}

	public ItemLista findById(Integer id) {
		Optional<ItemLista> obj = repository.findById(id);

		return obj.get();
	}

	public ItemLista create(Integer idLista, Integer idPeople, Integer idLocale, ItemLista obj) {
		obj.setId(null);
		Optional<Lista> lista = listaRepository.findById(idLista);
		Optional<Pessoa> pessoa = pessoaRepository.findById(idPeople);
		Optional<Catalogo> catalogo = catalogoRepository.findById(idLocale);
		LocalDateTime date = LocalDateTime.now();
		obj.setDate(date);
		obj.setLista(lista.get());
		obj.setPessoa(pessoa.get());
		obj.setCatalogo(catalogo.get());

		return repository.save(obj);

	}

}
