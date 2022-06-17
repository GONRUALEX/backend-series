package com.series.streaming.series.model.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class TableValue <T extends TableValueEnum> implements MasterTable{

	@Column(name="DESCRIPTION")
	protected String description;
	
	@Column(name="HIGH_DATE")
	protected String highDate;
	
	@Column(name="LOW_DATE")
	protected String lowDate;
	
	@Column(name= "VALID")
	private Boolean valid;
	
	public abstract T getCode();
	
	public abstract void setCode(T code);

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHighDate() {
		return highDate;
	}

	public void setHighDate(String highDate) {
		this.highDate = highDate;
	}

	public String getLowDate() {
		return lowDate;
	}

	public void setLowDate(String lowDate) {
		this.lowDate = lowDate;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	
	
}
