package com.csti.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csti.app.model.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Integer> {

}
