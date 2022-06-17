package com.series.streaming.series.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.series.streaming.series.model.base.Auditable;
import com.series.streaming.series.model.taulavalor.Plataformas;

@Entity
@Table(name = "SERIES")
@EntityListeners(AuditingEntityListener.class)
public class Series extends Auditable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NOMBRE", length = 100, nullable = false)
	private String nombre;
	
	@Lob
	@Column(name = "CARATULA")
	private byte[] caratula;
	
	@Column(name = "SINOPSIS", length = 100, nullable = false)
	private String sinopsis;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PLATAFORMA")
	private Plataformas plataforma;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getCaratula() {
		return caratula;
	}

	public void setCaratula(byte[] caratula) {
		this.caratula = caratula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public Plataformas getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataformas plataforma) {
		this.plataforma = plataforma;
	}
	
}
