package com.series.streaming.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import com.series.streaming.bean.SeriesDto;
import com.series.streaming.bean.ValoracionesDto;
import com.series.streaming.series.model.Series;
import com.series.streaming.series.model.Valoraciones;
import com.series.streaming.series.repository.SeriesRepository;
import com.series.streaming.series.repository.UsuariosRepository;
import com.series.streaming.series.repository.taulavalor.PlataformasRepository;

@Mapper(componentModel = "spring")
public abstract class ValoracionesMapper {
	
	@Autowired
	private SeriesRepository seriesRepository;
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@Mappings({
		@Mapping(source = "valoraciones.id", target = "id"),
		@Mapping(source = "valoraciones.valoracion", target = "valoracion"),
		@Mapping(source = "valoraciones.serie", target = "serie"),
		@Mapping(source = "valoraciones.usuario", target = "usuario")
	})
	public abstract ValoracionesDto simpleToDto(Valoraciones valoraciones);
	
	public ValoracionesDto toDto(Valoraciones valoraciones) {
		ValoracionesDto valoracionesDto = this.simpleToDto(valoraciones);
		
		return valoracionesDto;
	}
	
	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "valoracion", target = "valoracion"),
		@Mapping(target = "serie", ignore = true),
		@Mapping(target = "usuario", ignore = true),
		@Mapping(target = "createdBy", ignore = true),
		@Mapping(target = "createdDate", ignore = true),
		@Mapping(target = "lastMofifiedDate", ignore = true),
		@Mapping(target = "modifiedBy", ignore = true),
		@Mapping(target = "version", ignore = true)
	})
	public abstract void simpleDtoToModel(ValoracionesDto dto, @MappingTarget Valoraciones model);

	public void dtoToModel(ValoracionesDto dto, Valoraciones model) {
		this.simpleDtoToModel(dto,  model);
		model.setUsuario(usuariosRepository.findOne(dto.getUsuario().getId()));
		model.setSerie(seriesRepository.findOne(dto.getSerie().getId()));
	}
	
	public List<ValoracionesDto> toListResultsDto(List<Valoraciones> result){
		List<ValoracionesDto> resultDto = new ArrayList<ValoracionesDto>();
		for (Valoraciones model:result) {
			resultDto.add(toDto(model));
		}
		return resultDto;
	}

}
