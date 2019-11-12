package CustomerF;
import java.util.Date;

public class Suport extends Feedback {
	protected String intrebareCLient;
	protected String raspunsAsistent;
	protected String getIntrebareCLient() {
		return intrebareCLient;
	}
	protected void setIntrebareCLient(String intrebareCLient) {
		this.intrebareCLient = intrebareCLient;
	}
	protected String getRaspunsAsistent() {
		return raspunsAsistent;
	}
	protected void setRaspunsAsistent(String raspunsAsistent) {
		this.raspunsAsistent = raspunsAsistent;
	}
	public Suport(Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare, Date deadline,
			String titlu, String descriere, String tipFeedback, String intrebareCLient, String raspunsAsistent) {
		super(idFeedback, status, proiect, user, dataInregistrare, deadline, titlu, descriere, tipFeedback);
		this.intrebareCLient = intrebareCLient;
		this.raspunsAsistent = raspunsAsistent;
	}
	public Suport() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	
}
