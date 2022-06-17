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

import com.series.streaming.bean.ValoracionesDto;
import com.series.streaming.series.service.ValoracionesService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/valoraciones")
public class ValoracionesController  {
	
	@Autowired
	private ValoracionesService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public ResponseEntity<ValoracionesDto> createValoraciones(@RequestBody ValoracionesDto valoracionesDto) {
		ValoracionesDto result = service.createValoraciones(valoracionesDto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.GET, value= "/valoraciones")
	public ResponseEntity<List<ValoracionesDto>> getValoraciones(){
		List<ValoracionesDto> result = service.getValoraciones();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.DELETE, value= "/{id}")
	public ResponseEntity<Void> deleteValoraciones(@PathVariable Long id){
		service.deleteValoraciones(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.GET, value= "/{id}")
	public ResponseEntity<ValoracionesDto> getValoracionesById(@PathVariable Long id){
		ValoracionesDto result = service.getValoracionesById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
