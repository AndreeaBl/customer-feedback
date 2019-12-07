package org.app.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Cerinta {
	@Min(1) @NotNull(message = " idCerinta este necesar!")
	@Id @GeneratedValue
	private Integer idCerinta;
	@ManyToOne
	private User userAdaugare;
	@ManyToOne
	private User userAsignat;
	//RELATIE COMPOZIT CERINTA-FEEDBACK
	@ManyToOne
	private Feedback feedback;
	private String descriereCerinta;
	@Future(message = " Deadline trebuie sa fie o data in viitor!")
	@Temporal(TemporalType.DATE)
	private Date deadline;
	
	public Integer getIdCerinta() {
		return idCerinta;
	}
	public void setIdCerinta(Integer idCerinta) {
		this.idCerinta = idCerinta;
	}
	public User getUserAdaugare() {
		return userAdaugare;
	}
	public void setUserAdaugare(User userAdaugare) {
		this.userAdaugare = userAdaugare;
	}
	public User getUserAsignat() {
		return userAsignat;
	}
	public void setUserAsignat(User userAsignat) {
		this.userAsignat = userAsignat;
	}
	public Feedback getFeedback() {
		return feedback;
	}
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	public String getDescriereCerinta() {
		return descriereCerinta;
	}
	public void setDescriereCerinta(String descriereCerinta) {
		this.descriereCerinta = descriereCerinta;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Cerinta(Integer idCerinta, User userAdaugare, User userAsignat, Feedback feedback, String descriereCerinta,
			Date deadline) {
		super();
		this.idCerinta = idCerinta;
		this.userAdaugare = userAdaugare;
		this.userAsignat = userAsignat;
		this.feedback = feedback;
		this.descriereCerinta = descriereCerinta;
		this.deadline = deadline;
	}
	public Cerinta() {
		super();
	}
	
	
}
