package com.series.streaming.series.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.series.streaming.series.model.Valoraciones;

@Repository
public interface ValoracionesRepository extends JpaRepository<Valoraciones, Long>{
	
	@Query(value = "SELECT val FROM Valoraciones val WHERE 1 = 1 AND :id IS NULL OR val.id = :id")
	Valoraciones findOne(Long id);

}