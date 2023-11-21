package com.csti.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csti.app.model.ItemLista;
import com.csti.app.model.Lista;

@Repository
public interface ItemListaRepository extends JpaRepository<ItemLista, Integer> {
	
	List<ItemLista> findAllByLista(Lista lista);

}
