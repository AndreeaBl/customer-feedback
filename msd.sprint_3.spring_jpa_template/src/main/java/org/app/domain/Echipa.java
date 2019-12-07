package org.app.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Echipa {
	@Min(1) @NotNull(message = " idEchipa este necesar!")
	@Id @GeneratedValue
	private Integer idEchipa;
	@NotNull(message = " Denumirea echipei este necesara!") 
	@Size(min=1, message = "Echipa trebuie sa aiba un nume explicit!")
	private String denumireEchipa;
	private String descriereEchipa;
	private String tipEchipa;
	//PE NET ASA AM GASIT PENTRU RELATIE DE AGREGARE ECHIPA-USER. IS IT OK?
	//PENTRU -private User user- NU A FOST FACUT GET-UL SI SET-UL
	//https://stackoverflow.com/questions/38311717/aggregation-relationship-via-jpa-annotations
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	private User user;
	
	public Integer getIdEchipa() {
		return idEchipa;
	}
	public void setIdEchipa(Integer idEchipa) {
		this.idEchipa = idEchipa;
	}
	public String getDenumireEchipa() {
		return denumireEchipa;
	}
	public void setDenumireEchipa(String denumireEchipa) {
		this.denumireEchipa = denumireEchipa;
	}
	public String getDescriereEchipa() {
		return descriereEchipa;
	}
	public void setDescriereEchipa(String descriereEchipa) {
		this.descriereEchipa = descriereEchipa;
	}
	public String getTipEchipa() {
		return tipEchipa;
	}
	public void setTipEchipa(String tipEchipa) {
		this.tipEchipa = tipEchipa;
	}
	public Echipa(Integer idEchipa, String denumireEchipa, String descriereEchipa, String tipEchipa) {
		super();
		this.idEchipa = idEchipa;
		this.denumireEchipa = denumireEchipa;
		this.descriereEchipa = descriereEchipa;
		this.tipEchipa = tipEchipa;
	}
	public Echipa() {
		super();
	}
	
	
}
