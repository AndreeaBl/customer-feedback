import java.util.Date;

public abstract class Feedback {
	private Integer idFeedback;
	private Status status;
	public Proiect proiect;
	public User user;
	private Date dataInregistrare;
	private Date deadline;
	private String titlu;
	private String descriere;
	private String tipFeedback;
	private List<Comentariu> listaComentarii= new ArrayList<Comentariu>;
	private List<Atasament> listaAtasamente = new ArrayList<Atasament>;
	private List<Cerinta> listaCerinte= new ArrayList<Cerinta>;
	

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




	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

