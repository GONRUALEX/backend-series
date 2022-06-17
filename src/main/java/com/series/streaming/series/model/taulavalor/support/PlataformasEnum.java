package com.series.streaming.series.model.taulavalor.support;

import com.series.streaming.series.model.base.TableValueEnum;

public enum PlataformasEnum implements TableValueEnum{
	
	HBO("HBO");
	
	private String codi;
	
	private PlataformasEnum(String codi) {
		this.codi = codi;
	}
	
	public String getCode() {
		return codi;
	}
	
	public static PlataformasEnum fromValue(String codi) {
		for(PlataformasEnum value: PlataformasEnum.values()) {
			if (value.getCode().equals(codi)) {
				return value;
			}
		}
		return null;
	}
	
}
