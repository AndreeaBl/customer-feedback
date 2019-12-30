package org.app.domain;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Feedback {
	@Min(1) @NotNull(message = " idFeedback este necesar!")
	@Id @GeneratedValue
	private Integer idFeedback;
	@NotNull(message = " Statusul feedback-ului este necesar!") 
	@ManyToOne
	private Status status;
	@ManyToOne
	private Proiect proiect;
	@ManyToOne
	private User user;
	@Temporal(TemporalType.DATE)
	private Date dataInregistrare;
	@Future(message = " Deadline trebuie sa fie o data in viitor!")
	@Temporal(TemporalType.DATE)
	private Date deadline;
	private String titlu;
	private String descriere;
	private String tipFeedback;
	@OneToMany(mappedBy="feedback", cascade = CascadeType.ALL, fetch = FetchType.EAGER,
			orphanRemoval = true)
	private List<Comentariu> listaComentarii= new ArrayList<Comentariu>();
	@OneToMany(mappedBy="feedback", cascade = CascadeType.ALL, fetch = FetchType.LAZY,
			orphanRemoval = true)
	private List<Atasament> listaAtasamente = new ArrayList<Atasament>();
	@OneToMany(mappedBy="feedback", cascade = CascadeType.ALL, fetch = FetchType.LAZY,
			orphanRemoval = true)
	private List<Cerinta> listaCerinte= new ArrayList<Cerinta>();
	
	protected Integer comentariuCount = 0;
	
	protected Integer atasamentCount = 0;
	
	protected Integer cerintaCount = 0;
	

	public Integer getComentariuCount() {
		return comentariuCount;
	}

	public void setComentariuCount(Integer comentariuCount) {
		this.comentariuCount = comentariuCount;
	}

	public Integer getAtasamentCount() {
		return atasamentCount;
	}

	public void setAtasamentCount(Integer atasamentCount) {
		this.atasamentCount = atasamentCount;
	}

	public Integer getCerintaCount() {
		return cerintaCount;
	}

	public void setCerintaCount(Integer cerintaCount) {
		this.cerintaCount = cerintaCount;
	}

	public Feedback(Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback, List<Comentariu> listaComentarii,
			List<Atasament> listaAtasamente, List<Cerinta> listaCerinte) {
		super();
		this.idFeedback = idFeedback;
		this.status = status;
		this.proiect = proiect;
		this.user = user;
		this.dataInregistrare = dataInregistrare;
		this.deadline = deadline;
		this.titlu = titlu;
		this.descriere = descriere;
		this.tipFeedback = tipFeedback;
		this.listaComentarii = listaComentarii;
		this.listaAtasamente = listaAtasamente;
		this.listaCerinte = listaCerinte;
	}
	
	public Feedback(Integer idFeedback, String titlu, String tipFeedback) {
		super();
		this.idFeedback = idFeedback;
		this.titlu = titlu;
		this.tipFeedback = tipFeedback;
	}
	
	public Integer getIdFeedback() {
		return idFeedback;
	}
	public void setIdFeedback(Integer idFeedback) {
		this.idFeedback = idFeedback;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Proiect getProiect() {
		return proiect;
	}
	public void setProiect(Proiect proiect) {
		this.proiect = proiect;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDataInregistrare() {
		return dataInregistrare;
	}
	public void setDataInregistrare(Date dataInregistrare) {
		this.dataInregistrare = dataInregistrare;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getTitlu() {
		return titlu;
	}
	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}
	public String getDescriere() {
		return descriere;
	}
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
	public String getTipFeedback() {
		return tipFeedback;
	}
	public void setTipFeedback(String tipFeedback) {
		this.tipFeedback = tipFeedback;
	}
	public List<Comentariu> getListaComentarii() {
		return listaComentarii;
	}
	public void setListaComentarii(List<Comentariu> listaComentarii) {
		this.listaComentarii = listaComentarii;
	}
	public List<Atasament> getListaAtasamente() {
		return listaAtasamente;
	}
	public void setListaAtasamente(List<Atasament> listaAtasamente) {
		this.listaAtasamente = listaAtasamente;
	}
	public List<Cerinta> getListaCerinte() {
		return listaCerinte;
	}
	public void setListaCerinte(List<Cerinta> listaCerinte) {
		this.listaCerinte = listaCerinte;
	}
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feedback(Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback) {
		super();
		this.idFeedback = idFeedback;
		this.status = status;
		this.proiect = proiect;
		this.user = user;
		this.dataInregistrare = dataInregistrare;
		this.deadline = deadline;
		this.titlu = titlu;
		this.descriere = descriere;
		this.tipFeedback = tipFeedback;
	}

	@Override
	public String toString() {
		return "Feedback [idFeedback=" + idFeedback + ", status=" + status + ", proiect=" + proiect + ", user=" + user
				+ ", dataInregistrare=" + dataInregistrare + ", deadline=" + deadline + ", titlu=" + titlu
				+ ", descriere=" + descriere + ", tipFeedback=" + tipFeedback + ", listaComentarii=" + listaComentarii
				+ ", listaAtasamente=" + listaAtasamente + ", listaCerinte=" + listaCerinte + ", comentariuCount="
				+ comentariuCount + ", atasamentCount=" + atasamentCount + ", cerintaCount=" + cerintaCount + "]";
	}
	
	
}