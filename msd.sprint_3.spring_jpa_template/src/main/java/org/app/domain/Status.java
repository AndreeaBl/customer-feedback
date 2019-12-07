package org.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Status {
	
	@Min(1) @NotNull(message = " idStatus este necesar!")
	@Id @GeneratedValue
	private Integer idStatus;
	private String denumire;
	
	public Integer getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Status(Integer idStatus, String denumire) {
		super();
		this.idStatus = idStatus;
		this.denumire = denumire;
	}
	@Override
	public String toString() {
		return "Status [idStatus=" + idStatus + ", denumire=" + denumire + "]";
	}
	
	
}
