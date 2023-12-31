package com.csti.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.csti.app.model.Catalogo;

@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, Integer> {
	
	List<Catalogo> findAllBySetorIgnoreCaseContaining(String setor);
	
	@Query("FROM Catalogo c WHERE UPPER(c.setor) LIKE %?1%")
	List<Catalogo> findAllBySetor(String setor);

}
