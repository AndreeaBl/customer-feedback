package CustomerF;
import java.util.Date;

public abstract class Feedback {
	private Integer idFeedback;
	private Status status;
	private Proiect proiect;
	private User user;
	private Date dataInregistrare;
	private Date deadline;
	private String titlu;
	private String descriere;
	private String tipFeedback;
	private List<Comentariu> listaComentarii= new ArrayList<Comentariu>;
	private List<Atasament> listaAtasamente = new ArrayList<Atasament>;
	private List<Cerinta> listaCerinte= new ArrayList<Cerinta>;
	



	protected Integer getIdFeedback() {
		return idFeedback;
	}
	protected void setIdFeedback(Integer idFeedback) {
		this.idFeedback = idFeedback;
	}
	protected Status getStatus() {
		return status;
	}
	protected void setStatus(Status status) {
		this.status = status;
	}
	protected Proiect getProiect() {
		return proiect;
	}
	protected void setProiect(Proiect proiect) {
		this.proiect = proiect;
	}
	protected User getUser() {
		return user;
	}
	protected void setUser(User user) {
		this.user = user;
	}
	protected Date getDataInregistrare() {
		return dataInregistrare;
	}
	protected void setDataInregistrare(Date dataInregistrare) {
		this.dataInregistrare = dataInregistrare;
	}
	protected Date getDeadline() {
		return deadline;
	}
	protected void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	protected String getTitlu() {
		return titlu;
	}
	protected void setTitlu(String titlu) {
		this.titlu = titlu;
	}
	protected String getDescriere() {
		return descriere;
	}
	protected void setDescriere(String descriere) {
		this.descriere = descriere;
	}
	protected String getTipFeedback() {
		return tipFeedback;
	}
	protected void setTipFeedback(String tipFeedback) {
		this.tipFeedback = tipFeedback;
	}
	protected List<Comentariu> getListaComentarii() {
		return listaComentarii;
	}
	protected void setListaComentarii(List<Comentariu> listaComentarii) {
		this.listaComentarii = listaComentarii;
	}
	protected List<Atasament> getListaAtasamente() {
		return listaAtasamente;
	}
	protected void setListaAtasamente(List<Atasament> listaAtasamente) {
		this.listaAtasamente = listaAtasamente;
	}
	protected List<Cerinta> getListaCerinte() {
		return listaCerinte;
	}
	protected void setListaCerinte(List<Cerinta> listaCerinte) {
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
	
	