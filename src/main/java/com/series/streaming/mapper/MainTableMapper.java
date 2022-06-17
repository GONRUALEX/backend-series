package com.series.streaming.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.series.streaming.bean.MainTableDto;
import com.series.streaming.series.model.base.MasterTable;

@Mapper(componentModel = "spring")
public abstract class MainTableMapper {

public abstract MainTableDto toDto(Long id, String descripcio, Boolean valid);

public abstract MainTableDto toDto(MasterTable masterTable);

public abstract List<MainTableDto> toDto(List<? extends MasterTable> llista);

}