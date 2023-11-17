package com.csti.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csti.app.model.Lista;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Integer> {

}
