package com.series.streaming.series.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.series.streaming.bean.MainTableDto;
import com.series.streaming.mapper.MainTableMapper;
import com.series.streaming.series.repository.taulavalor.PlataformasRepository;
import com.series.streaming.series.service.MasterTableService;

@Service
public class MasterTableServiceImpl implements MasterTableService{

	@Autowired
	private MainTableMapper mapper;
	
	@Autowired
	private PlataformasRepository plataformaRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<MainTableDto> getPlataforma(){
		return mapper.toDto(plataformaRepository.findAllByOrderByDescriptionAsc());
	}
}
