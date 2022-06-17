package com.series.streaming.series.model.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {
	
	@Column(name="USUARIO_CREACIO")
	@CreatedBy
	protected String createdBy;

	@Column(name = "DATA_CREACIO")
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;
	
	@Column(name = "DATA_MODIFICACIO")
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastMofifiedDate;
	
	@Column(name="USUARI_MODIFICACIO")
	@CreatedBy
	protected String modifiedBy;
	
	@Version
	@Column(name = "VERSION")
	protected Long version;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastMofifiedDate() {
		return lastMofifiedDate;
	}

	public void setLastMofifiedDate(Date lastMofifiedDate) {
		this.lastMofifiedDate = lastMofifiedDate;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
}
