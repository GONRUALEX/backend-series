package com.series.streaming.series.model.taulavalor.support;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PlataformasConverter implements AttributeConverter<PlataformasEnum, String>{
	
	public String convertToDatabaseColumn(PlataformasEnum attribute) {
		return attribute != null ? attribute.getCode() : null;
	}
	
	public PlataformasEnum convertToEntityAttribute(String codi) {
		return PlataformasEnum.fromValue(codi);
	}
}
