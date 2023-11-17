package com.csti.app.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csti.app.dtos.ListaDTO;
import com.csti.app.model.Equipe;
import com.csti.app.model.Lista;
import com.csti.app.repositories.ListaRepository;

@Service
public class ListaService {

	@Autowired
	private ListaRepository listaRepository;

	@Autowired
	private EquipeService equipeService;

	public List<ListaDTO> findAll() {
		List<Lista> lista = listaRepository.findAll();
		List<ListaDTO> listaDTO = lista.stream().map(obj -> new ListaDTO(obj)).collect(Collectors.toList());
		return listaDTO;
	}

	public Lista findById(Integer id) {
		Optional<Lista> list = listaRepository.findById(id);
		return list.get();
	}

	public ListaDTO findByIdDTO(Integer id) {
		ListaDTO listaDTO = new ListaDTO(findById(id));
		return listaDTO;
	}

	public Lista create(Integer id_equipe, Lista obj) {
		Equipe equipe = equipeService.findById(id_equipe);

		obj.setId(null);
		obj.setDate(this.serCurrentDateTime());
		obj.setEquipe(equipe);
		
		return listaRepository.save(obj);
	}

	public Lista update(Integer id_lista, Integer id_equipe, Lista obj) {
		Lista lista = findById(id_lista);
		Equipe equipe = equipeService.findById(id_equipe);

		lista.setDescricao(obj.getDescricao());
		lista.setDate(this.serCurrentDateTime());
		lista.setEquipe(equipe);

		return listaRepository.save(lista);

	}

	public void delete(Integer id) {
		Lista lista = findById(id);
		if (lista.getItens() != null) {
			listaRepository.delete(lista);
		}
	}
	
	private LocalDateTime serCurrentDateTime() {
		LocalDateTime returnCurrentDateTime = LocalDateTime.now();
		return returnCurrentDateTime;
	}

}
