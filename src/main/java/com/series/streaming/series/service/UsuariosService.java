package com.series.streaming.series.service;

import java.util.List;

import com.series.streaming.bean.UsuariosDto;

public interface UsuariosService {

	UsuariosDto createUsuarios(UsuariosDto usuarios);
	
	List<UsuariosDto> getUsuarios();
	
	void deleteUsuarios(Long id);
	
	UsuariosDto getUsuariosByNombreAndApellido(UsuariosDto usuarios);
	
	UsuariosDto getUsuariosById(Long id);
	
}
