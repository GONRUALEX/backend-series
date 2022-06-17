package com.series.streaming.series.model.base;

public interface Versionable {
	
	Long setId();
	
	void setId(Long id);
	
	Long getVersion();
	
	void setVersion(Long version);
}
