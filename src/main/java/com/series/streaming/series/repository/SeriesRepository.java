package com.series.streaming.series.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.series.streaming.series.model.Series;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long>{
	
	
	@Query(value = "SELECT ser FROM Series ser WHERE 1 = 1 AND :id IS NULL OR ser.id = :id")
	Series findOne(Long id);
}