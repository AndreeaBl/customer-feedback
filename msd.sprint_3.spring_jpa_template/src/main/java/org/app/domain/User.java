package org.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class User {
	@Id @GeneratedValue
	private Integer idUser;
	private String numePrescurtat;
	private String numePrenume;
	private String mail;
	//NOTA: JoinColumn (foreign key in the database terminology) 
	//must be on the many side of the aggregate relationship
	//PENTRU private Echipa echipa NU A FOST FACUT GET-UL SI SET-UL
	@JoinColumn(name="idUser")
	private Echipa echipa;
	
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getNumePrescurtat() {
		return numePrescurtat;
	}
	public void setNumePrescurtat(String numePrescurtat) {
		this.numePrescurtat = numePrescurtat;
	}
	public String getNumePrenume() {
		return numePrenume;
	}
	public void setNumePrenume(String numePrenume) {
		this.numePrenume = numePrenume;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public User(Integer idUser, String numePrescurtat, String numePrenume, String mail) {
		super();
		this.idUser = idUser;
		this.numePrescurtat = numePrescurtat;
		this.numePrenume = numePrenume;
		this.mail = mail;
	}
	public User() {
		super();
	}
	
	
}
