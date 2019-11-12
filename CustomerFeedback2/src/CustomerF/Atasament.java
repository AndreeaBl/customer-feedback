package CustomerF;

import java.util.Date;

public class Atasament {
	private Integer idAtasament;
	private User user;
	private Feedback feedback;
	private String numeFisier;
	private String tipFisier;
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
