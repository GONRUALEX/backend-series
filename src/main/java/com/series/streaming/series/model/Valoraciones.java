package com.series.streaming.series.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.series.streaming.series.model.base.Auditable;

@Entity
@Table(name = "VALORACIONES")
@EntityListeners(AuditingEntityListener.class)
public class Valoraciones extends Auditable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SERIE")
	private Series serie;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USUARIO")
	private Usuarios usuario;
	
	@Column(name = "VALORACION", length = 250, nullable = false)
	private String valoracion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Series getSerie() {
		return serie;
	}

	public void setSerie(Series serie) {
		this.serie = serie;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public String getValoracion() {
		return valoracion;
	}

	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}
	
}
