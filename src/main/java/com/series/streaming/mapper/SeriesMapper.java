package com.series.streaming.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import com.series.streaming.bean.SeriesDto;
import com.series.streaming.series.model.Series;
import com.series.streaming.series.repository.taulavalor.PlataformasRepository;

@Mapper(componentModel = "spring")
public abstract class SeriesMapper {

	@Autowired
	private MainTableMapper mainTableMapper;
	
	@Autowired
	private PlataformasRepository plataformaRepository;
	
	@Mappings({
		@Mapping(source = "serie.id", target = "id"),
		@Mapping(source = "serie.nombre", target = "nombre"),
		@Mapping(source = "serie.caratula", target = "caratula"),
		@Mapping(source = "serie.sinopsis", target = "sinopsis"),
		@Mapping(target = "plataforma", ignore = true)
	})
	public abstract SeriesDto simpleToDto(Series serie);
	
	public SeriesDto toDto(Series series) {
		SeriesDto seriesDto = this.simpleToDto(series);
		
		if (series.getPlataforma() != null) {
			seriesDto.setPlataforma(mainTableMapper.toDto(series.getPlataforma()));
		}
		
		return seriesDto;
	}
	
	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "nombre", target = "nombre"),
		@Mapping(source="caratula", target ="caratula"),
		@Mapping(source = "sinopsis", target = "sinopsis"),
		@Mapping(target = "plataforma", ignore = true),
		@Mapping(target = "createdBy", ignore = true),
		@Mapping(target = "createdDate", ignore = true),
		@Mapping(target = "lastMofifiedDate", ignore = true),
		@Mapping(target = "modifiedBy", ignore = true),
		@Mapping(target = "version", ignore = true)
	})
	public abstract void simpleDtoToModel(SeriesDto dto, @MappingTarget Series model);

	public void dtoToModel(SeriesDto dto, Series model) {
		this.simpleDtoToModel(dto,  model);
		model.setPlataforma(plataformaRepository.findOne(dto.getPlataforma().getId()));
	}
	
	public List<SeriesDto> toListResultsDto(List<Series> result){
		List<SeriesDto> resultDto = new ArrayList<SeriesDto>();
		for (Series model:result) {
			resultDto.add(toDto(model));
		}
		return resultDto;
	}

}
