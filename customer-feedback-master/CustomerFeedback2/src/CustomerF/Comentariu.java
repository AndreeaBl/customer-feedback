package CustomerF;

import java.util.Date;

public class Comentariu {
	private Integer idComentariu;
	private User user;
	private Feedback feedback;
	private String textComentariu;
	private Date dataOra;
	public Integer getIdComentariu() {
		return idComentariu;
	}
	public void setIdComentariu(Integer idComentariu) {
		this.idComentariu = idComentariu;
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
	public String getTextComentariu() {
		return textComentariu;
	}
	public void setTextComentariu(String textComentariu) {
		this.textComentariu = textComentariu;
	}
	public Date getDataOra() {
		return dataOra;
	}
	public void setDataOra(Date dataOra) {
		this.dataOra = dataOra;
	}
	public Comentariu(Integer idComentariu, User user, Feedback feedback, String textComentariu, Date dataOra) {
		super();
		this.idComentariu = idComentariu;
		this.user = user;
		this.feedback = feedback;
		this.textComentariu = textComentariu;
		this.dataOra = dataOra;
	}
	public Comentariu() {
		super();
	}
	
	
}
