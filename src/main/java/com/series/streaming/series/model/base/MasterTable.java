package com.series.streaming.series.model.base;

public interface MasterTable {

	Long getId();
	
	void setId();
	
	String getDescription();
	
	void setDescription(String Description);
	
	Boolean getValid();
	
	void setValid(Boolean valid);
}
