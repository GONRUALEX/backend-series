package com.series.streaming.series.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.series.streaming.bean.UsuariosDto;
import com.series.streaming.mapper.UsuariosMapper;
import com.series.streaming.series.model.Usuarios;
import com.series.streaming.series.repository.UsuariosRepository;
import com.series.streaming.series.service.UsuariosService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service("usuariosService")
public class UsuariosServiceImpl implements UsuariosService {

	private static final Logger logger = LogManager.getLogger(UsuariosServiceImpl.class);
	
	@Autowired
	private UsuariosMapper usuariosMapper;

	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@Override
	@Transactional
	public UsuariosDto createUsuarios(UsuariosDto dto) {
		Usuarios model = new Usuarios();
       
		usuariosMapper.dtoToModel(dto, model);
       
		usuariosRepository.save(model);
       
       logger.debug("Create new usuarios with id {}", model.getId());
       
       return usuariosMapper.toDto(model);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public UsuariosDto getUsuariosByNombreAndApellido(UsuariosDto dto) {
       
		Usuarios model = usuariosRepository.getUsuariosByNombreAndApellido(dto.getNombre(), dto.getApellido());
       
       return usuariosMapper.toDto(model);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<UsuariosDto> getUsuarios() {
		List<UsuariosDto> modelList;
		
		modelList = usuariosMapper.toListResultsDto(usuariosRepository.findAll());
		return modelList;
		
	}
	
	@Override
	@Transactional
	public void deleteUsuarios(Long id) {
		Usuarios model = usuariosRepository.findOne(id);
		usuariosRepository.delete(model);
		logger.debug("Delete Usuarios with id {}", model.getId());
	}
	
	@Override
	@Transactional(readOnly = true)
	public UsuariosDto getUsuariosById(Long id) {
		Usuarios model = usuariosRepository.findOne(id);
      
	    return usuariosMapper.toDto(model);
	}
	
}
