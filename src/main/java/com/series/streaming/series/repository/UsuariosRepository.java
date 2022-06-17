package com.series.streaming.series.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.series.streaming.series.model.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{
	
	@Query(value = "SELECT us FROM Usuarios us WHERE 1 = 1 AND :id IS NULL OR us.id = :id")
	Usuarios findOne(@Param("id") Long id);
	
	@Query(value = "SELECT us FROM Usuarios us WHERE 1 = 1 AND :nombre IS NULL OR us.nombre = :nombre AND :apellido IS NULL OR us.apellido = :apellido")
	Usuarios getUsuariosByNombreAndApellido(@Param("nombre") String nombre, @Param("apellido") String apellido);

}