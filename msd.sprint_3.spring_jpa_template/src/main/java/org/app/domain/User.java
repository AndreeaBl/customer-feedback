package org.app.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="Users")
public class User {
	@Id @GeneratedValue
	private Integer idUser;
	private String numePrescurtat;
	private String numePrenume;
	private String mail;
		
	@ManyToOne
	private Echipa echipa;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((echipa == null) ? 0 : echipa.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((numePrenume == null) ? 0 : numePrenume.hashCode());
		result = prime * result + ((numePrescurtat == null) ? 0 : numePrescurtat.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (echipa == null) {
			if (other.echipa != null)
				return false;
		} else if (!echipa.equals(other.echipa))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (numePrenume == null) {
			if (other.numePrenume != null)
				return false;
		} else if (!numePrenume.equals(other.numePrenume))
			return false;
		if (numePrescurtat == null) {
			if (other.numePrescurtat != null)
				return false;
		} else if (!numePrescurtat.equals(other.numePrescurtat))
			return false;
		return true;
	}
	public Echipa getEchipa() {
		return echipa;
	}
	public void setEchipa(Echipa echipa) {
		this.echipa = echipa;
	}
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
