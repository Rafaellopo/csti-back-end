package com.csti.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csti.app.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}
