package com.csti.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csti.app.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

}
