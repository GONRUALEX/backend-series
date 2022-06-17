package com.series.streaming.series.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.series.streaming.bean.ValoracionesDto;
import com.series.streaming.mapper.ValoracionesMapper;
import com.series.streaming.series.model.Valoraciones;
import com.series.streaming.series.repository.ValoracionesRepository;
import com.series.streaming.series.service.ValoracionesService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service("valoracionesService")
public class ValoracionesServiceImpl implements ValoracionesService {

	private static final Logger logger = LogManager.getLogger(ValoracionesServiceImpl.class);
	
	@Autowired
	private ValoracionesMapper valoracionesMapper;

	@Autowired
	private ValoracionesRepository valoracionesRepository;
	
	@Override
	@Transactional
	public ValoracionesDto createValoraciones(ValoracionesDto dto) {
		Valoraciones model = new Valoraciones();
       
		valoracionesMapper.dtoToModel(dto, model);
       
		valoracionesRepository.save(model);
       
       logger.debug("Create new valoraciones with id {}", model.getId());
       
       return valoracionesMapper.toDto(model);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ValoracionesDto> getValoraciones() {
		List<ValoracionesDto> modelList;
		
		modelList = valoracionesMapper.toListResultsDto(valoracionesRepository.findAll());
		return modelList;
		
	}
	
	@Override
	@Transactional
	public void deleteValoraciones(Long id) {
		Valoraciones model = valoracionesRepository.findOne(id);
		valoracionesRepository.delete(model);
		logger.debug("Delete valoraciones with id {}", model.getId());
	}
	
	@Override
	@Transactional(readOnly = true)
	public ValoracionesDto getValoracionesById(Long id) {
		Valoraciones model = valoracionesRepository.findOne(id);
      
	    return valoracionesMapper.toDto(model);
	}
	
}
