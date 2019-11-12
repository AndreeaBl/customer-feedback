package CustomerF;

import java.util.Date;

public class Cerinta {
	private Integer idCerinta;
	private User userAdaugare;
	private User userAsignat;
	private Feedback feedback;
	private String descriereCerinta;
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
