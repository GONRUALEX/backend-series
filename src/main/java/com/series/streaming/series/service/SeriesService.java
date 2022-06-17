package com.series.streaming.series.service;

import java.util.List;

import com.series.streaming.bean.SeriesDto;
import com.series.streaming.series.model.Series;

public interface SeriesService {
	
	SeriesDto createSerie(SeriesDto serie);
	
	List<SeriesDto> getSeries();
	
	void deleteSeries(Long id);
	
	SeriesDto getSeriesById(Long id);

}
