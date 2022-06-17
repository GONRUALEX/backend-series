package com.series.streaming.series.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.series.streaming.bean.SeriesDto;
import com.series.streaming.mapper.SeriesMapper;
import com.series.streaming.series.model.Series;
import com.series.streaming.series.repository.SeriesRepository;
import com.series.streaming.series.service.SeriesService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service("seriesService")
public class SeriesServiceImpl implements SeriesService {

	private static final Logger logger = LogManager.getLogger(SeriesServiceImpl.class);
	
	@Autowired
	private SeriesMapper seriesMapper;

	@Autowired
	private SeriesRepository seriesRepository;
	
	@Override
	@Transactional
	public SeriesDto createSerie(SeriesDto dto) {
       Series model = new Series();
       
       seriesMapper.dtoToModel(dto, model);
       
       seriesRepository.save(model);
       
       logger.debug("Create new series with id {}", model.getId());
       
       return seriesMapper.toDto(model);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<SeriesDto> getSeries() {
		List<SeriesDto> modelList;
		
		modelList = seriesMapper.toListResultsDto(seriesRepository.findAll());
		return modelList;
		
	}
	
	@Override
	@Transactional
	public void deleteSeries(Long id) {
		Series model = seriesRepository.findOne(id);
		seriesRepository.delete(model);
		logger.debug("Delete series with id {}", model.getId());
	}
	
	@Override
	@Transactional(readOnly = true)
	public SeriesDto getSeriesById(Long id) {
		Series model = seriesRepository.findOne(id);
      
	    return seriesMapper.toDto(model);
	}
	
}
