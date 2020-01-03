package org.app.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import javax.persistence.OneToMany;
import static javax.persistence.CascadeType.ALL;

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

	@OneToMany(mappedBy = "echipa", cascade = ALL)
	private List<User> userList = new ArrayList<>();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((denumireEchipa == null) ? 0 : denumireEchipa.hashCode());
		result = prime * result + ((descriereEchipa == null) ? 0 : descriereEchipa.hashCode());
		result = prime * result + ((idEchipa == null) ? 0 : idEchipa.hashCode());
		result = prime * result + ((tipEchipa == null) ? 0 : tipEchipa.hashCode());
		result = prime * result + ((userList == null) ? 0 : userList.hashCode());
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
		Echipa other = (Echipa) obj;
		if (denumireEchipa == null) {
			if (other.denumireEchipa != null)
				return false;
		} else if (!denumireEchipa.equals(other.denumireEchipa))
			return false;
		if (descriereEchipa == null) {
			if (other.descriereEchipa != null)
				return false;
		} else if (!descriereEchipa.equals(other.descriereEchipa))
			return false;
		if (idEchipa == null) {
			if (other.idEchipa != null)
				return false;
		} else if (!idEchipa.equals(other.idEchipa))
			return false;
		if (tipEchipa == null) {
			if (other.tipEchipa != null)
				return false;
		} else if (!tipEchipa.equals(other.tipEchipa))
			return false;
		if (userList == null) {
			if (other.userList != null)
				return false;
		} else if (!userList.equals(other.userList))
			return false;
		return true;
	}
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
