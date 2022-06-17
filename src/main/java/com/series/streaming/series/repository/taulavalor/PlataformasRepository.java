package com.series.streaming.series.repository.taulavalor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.series.streaming.series.model.taulavalor.Plataformas;
import com.series.streaming.series.model.taulavalor.support.PlataformasEnum;

public interface PlataformasRepository extends JpaRepository<Plataformas, Long>{
	
	List<Plataformas> findAllByOrderByDescriptionAsc();

	List<Plataformas> findAll();
	
	Plataformas getByCode(PlataformasEnum code);
	
	String getCodeById(Long id);
	
	Long getIdByCode(String codi);
	
	@Query(value = "SELECT plat FROM Plataformas plat WHERE 1 = 1 AND :id IS NULL OR plat.id = :id")
	Plataformas findOne(Long id);
}
