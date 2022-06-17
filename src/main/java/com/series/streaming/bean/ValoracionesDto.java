package com.series.streaming.bean;

public class ValoracionesDto {

	private Long id;
	private MainTableDto serie;
	private MainTableDto usuario;
	private String valoracion;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public MainTableDto getSerie() {
		return serie;
	}
	public void setSerie(MainTableDto serie) {
		this.serie = serie;
	}
	public MainTableDto getUsuario() {
		return usuario;
	}
	public void setUsuario(MainTableDto usuario) {
		this.usuario = usuario;
	}
	public String getValoracion() {
		return valoracion;
	}
	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}
	
}
