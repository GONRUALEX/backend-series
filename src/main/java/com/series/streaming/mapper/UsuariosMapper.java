package com.series.streaming.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import com.series.streaming.bean.SeriesDto;
import com.series.streaming.bean.UsuariosDto;
import com.series.streaming.bean.ValoracionesDto;
import com.series.streaming.series.model.Series;
import com.series.streaming.series.model.Usuarios;
import com.series.streaming.series.model.Valoraciones;
import com.series.streaming.series.repository.SeriesRepository;
import com.series.streaming.series.repository.UsuariosRepository;
import com.series.streaming.series.repository.taulavalor.PlataformasRepository;

@Mapper(componentModel = "spring")
public abstract class UsuariosMapper {
	
	
	@Mappings({
		@Mapping(source = "usuarios.id", target = "id"),
		@Mapping(source = "usuarios.nombre", target = "nombre"),
		@Mapping(source = "usuarios.apellido", target = "apellido")
	})
	public abstract UsuariosDto simpleToDto(Usuarios usuarios);
	
	public UsuariosDto toDto(Usuarios usuarios) {
		UsuariosDto usuariosDto = this.simpleToDto(usuarios);
		
		return usuariosDto;
	}
	
	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "nombre", target = "nombre"),
		@Mapping(source = "apellido", target = "apellido"),
	})
	public abstract void simpleDtoToModel(UsuariosDto dto, @MappingTarget Usuarios model);

	public void dtoToModel(UsuariosDto dto, Usuarios model) {
		this.simpleDtoToModel(dto,  model);
	}
	
	public List<UsuariosDto> toListResultsDto(List<Usuarios> result){
		List<UsuariosDto> resultDto = new ArrayList<UsuariosDto>();
		for (Usuarios model:result) {
			resultDto.add(toDto(model));
		}
		return resultDto;
	}

}
