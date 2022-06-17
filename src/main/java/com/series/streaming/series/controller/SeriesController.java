package com.series.streaming.series.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.series.streaming.bean.SeriesDto;
import com.series.streaming.series.model.Series;
import com.series.streaming.series.service.SeriesService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/series")
public class SeriesController  {
	
	@Autowired
	private SeriesService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public ResponseEntity<SeriesDto> createSerie(@RequestBody SeriesDto serieDto) {
		SeriesDto result = service.createSerie(serieDto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.GET, value= "/series")
	public ResponseEntity<List<SeriesDto>> getSeries(){
		List<SeriesDto> result = service.getSeries();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.DELETE, value= "/{id}")
	public ResponseEntity<Void> deleteSerie(@PathVariable Long id){
		service.deleteSeries(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.GET, value= "/{id}")
	public ResponseEntity<SeriesDto> getSeriesById(@PathVariable Long id){
		SeriesDto result = service.getSeriesById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
