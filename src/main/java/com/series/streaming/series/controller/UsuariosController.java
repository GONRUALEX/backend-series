package com.series.streaming.series.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.series.streaming.bean.UsuariosDto;
import com.series.streaming.series.service.UsuariosService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/usuarios")
public class UsuariosController  {
	
	@Autowired
	private UsuariosService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public ResponseEntity<UsuariosDto> createUsuarios(@RequestBody UsuariosDto usuariosDto) {
		UsuariosDto result = service.createUsuarios(usuariosDto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.GET, value= "/usuarios")
	public ResponseEntity<List<UsuariosDto>> getUsuarios(){
		List<UsuariosDto> result = service.getUsuarios();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.DELETE, value= "/{id}")
	public ResponseEntity<Void> deleteUsuarios(@PathVariable Long id){
		service.deleteUsuarios(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.GET, value= "/{id}")
	public ResponseEntity<UsuariosDto> getUsuariosById(@PathVariable Long id){
		UsuariosDto result = service.getUsuariosById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/isLogged")
	public ResponseEntity<UsuariosDto> getUsuariosByNombreAndApellido(@RequestBody UsuariosDto usuariosDto) {
		UsuariosDto result = service.getUsuariosByNombreAndApellido(usuariosDto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
