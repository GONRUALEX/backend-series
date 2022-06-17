package com.series.streaming.bean;

public class SeriesDto {

private Long id;
	
	private String nombre;
	private byte[] caratula;
	private String sinopsis;
	private MainTableDto plataforma;
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
	public byte[] getCaratula() {
		return caratula;
	}
	public void setCaratula(byte[] caratula) {
		this.caratula = caratula;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public MainTableDto getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(MainTableDto plataforma) {
		this.plataforma = plataforma;
	}
}
