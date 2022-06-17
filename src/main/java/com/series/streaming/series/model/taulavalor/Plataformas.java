package com.series.streaming.series.model.taulavalor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.series.streaming.series.model.base.TableValue;
import com.series.streaming.series.model.taulavalor.support.PlataformasConverter;
import com.series.streaming.series.model.taulavalor.support.PlataformasEnum;

@Entity
@Table(name = "PLATAFORMAS")
public class Plataformas extends TableValue<PlataformasEnum> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Convert(converter = PlataformasConverter.class)
	@Column(name = "CODE")
	private PlataformasEnum code;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PlataformasEnum getCode() {
		return code;
	}

	public void setCode(PlataformasEnum code) {
		this.code = code;
	}

	@Override
	public void setId() {
		// TODO Auto-generated method stub
		
	}

	
}
