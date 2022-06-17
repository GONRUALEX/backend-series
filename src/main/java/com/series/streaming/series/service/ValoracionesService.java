package com.series.streaming.series.service;

import java.util.List;

import com.series.streaming.bean.ValoracionesDto;

public interface ValoracionesService {

	ValoracionesDto createValoraciones(ValoracionesDto valoraciones);
	
	List<ValoracionesDto> getValoraciones();
	
	void deleteValoraciones(Long id);
	
	ValoracionesDto getValoracionesById(Long id);
}
