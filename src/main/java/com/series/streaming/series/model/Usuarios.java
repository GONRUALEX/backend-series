package com.series.streaming.series.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.series.streaming.series.model.base.Auditable;

@Entity
@Table(name = "USUARIOS")
@EntityListeners(AuditingEntityListener.class)
public class Usuarios extends Auditable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NOMBRE", length = 100, nullable = false)
	private String nombre;
	
	@Column(name = "APELLIDO", length = 100, nullable = false)
	private String apellido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
