package org.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Proiect {
	@Min(1) @NotNull(message = " idProiect este necesar!")
	@Id @GeneratedValue
	private Integer idProiect;
	@ManyToOne
	private Echipa echipa;
	@NotNull(message = " Denumirea proiectului este necesara!") 
	@Size(min=1, message = "Proiectul trebuie sa aiba un nume explicit!")
	private String denumire;
	private String tipProiect;
	
	public Integer getIdProiect() {
		return idProiect;
	}
	public void setIdProiect(Integer idProiect) {
		this.idProiect = idProiect;
	}
	public Echipa getEchipa() {
		return echipa;
	}
	public void setEchipa(Echipa echipa) {
		this.echipa = echipa;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public String getTipProiect() {
		return tipProiect;
	}
	public void setTipProiect(String tipProiect) {
		this.tipProiect = tipProiect;
	}
	public Proiect(Integer idProiect, Echipa echipa, String denumire, String tipProiect) {
		super();
		this.idProiect = idProiect;
		this.echipa = echipa;
		this.denumire = denumire;
		this.tipProiect = tipProiect;
	}
	public Proiect() {
		super();
	}
	
	

}
