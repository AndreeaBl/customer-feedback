package org.app.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Bug extends Feedback {

	public Bug(Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback, List<Comentariu> listaComentarii,
			List<Atasament> listaAtasamente, List<Cerinta> listaCerinte) {
		super(idFeedback, status, proiect, user, dataInregistrare, deadline, titlu, descriere, tipFeedback, listaComentarii,
				listaAtasamente, listaCerinte);
		// TODO Auto-generated constructor stub
	}
	public Bug(Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback) {
		super(idFeedback, status, proiect, user, dataInregistrare, deadline, titlu, descriere, tipFeedback);
		// TODO Auto-generated constructor stub
	}
	public Bug(Integer idFeedback, String titlu, String tipFeedback) {
		super(idFeedback, titlu, tipFeedback);
		// TODO Auto-generated constructor stub
	}
	//AR TREBUI SA FIE LISTE?? https://vladmihalcea.com/how-to-inherit-properties-from-a-base-class-entity-using-mappedsuperclass-with-jpa-and-hibernate/
	protected String comportamentActual;
	protected String comportamentAsteptat;
	protected String textEroare;
	
	protected String getComportamentActual() {
		return comportamentActual;
	}
	protected void setComportamentActual(String comportamentActual) {
		this.comportamentActual = comportamentActual;
	}
	protected String getComportamentAsteptat() {
		return comportamentAsteptat;
	}
	protected void setComportamentAsteptat(String comportamentAsteptat) {
		this.comportamentAsteptat = comportamentAsteptat;
	}
	protected String getTextEroare() {
		return textEroare;
	}
	protected void setTextEroare(String textEroare) {
		this.textEroare = textEroare;
	}
	public Bug() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bug(String comportamentActual, String comportamentAsteptat, String textEroare) {
		super();
		this.comportamentActual = comportamentActual;
		this.comportamentAsteptat = comportamentAsteptat;
		this.textEroare = textEroare;
	}
	
	
}
