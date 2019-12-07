package org.app.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Atasament {
	@Min(1) @NotNull(message = " idAtasament este necesar!")
	@Id @GeneratedValue
	private Integer idAtasament;
	@ManyToOne
	private User user;
	//Relatie compozit Atasament-Feedback
	@ManyToOne
	private Feedback feedback;
	private String numeFisier;
	private String tipFisier;
	@Temporal(TemporalType.DATE)
	private Date dataAdaugare;
	
	public Integer getIdAtasament() {
		return idAtasament;
	}
	///test commit
	public void setIdAtasament(Integer idAtasament) {
		this.idAtasament = idAtasament;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Feedback getFeedback() {
		return feedback;
	}
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	public String getNumeFisier() {
		return numeFisier;
	}
	public void setNumeFisier(String numeFisier) {
		this.numeFisier = numeFisier;
	}
	public String getTipFisier() {
		return tipFisier;
	}
	public void setTipFisier(String tipFisier) {
		this.tipFisier = tipFisier;
	}
	public Date getDataAdaugare() {
		return dataAdaugare;
	}
	public void setDataAdaugare(Date dataAdaugare) {
		this.dataAdaugare = dataAdaugare;
	}
	public Atasament(Integer idAtasament, User user, Feedback feedback, String numeFisier, String tipFisier,
			Date dataAdaugare) {
		super();
		this.idAtasament = idAtasament;
		this.user = user;
		this.feedback = feedback;
		this.numeFisier = numeFisier;
		this.tipFisier = tipFisier;
		this.dataAdaugare = dataAdaugare;
	}
	public Atasament() {
		super();
	}
	
	
}
