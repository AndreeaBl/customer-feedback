package CustomerF;
import java.util.Date;

public class Imbunatatire extends Feedback {
	protected String motiv;
	protected String stareaActuala;
	protected String stareaDOrita;
	protected String getMotiv() {
		return motiv;
	}
	protected void setMotiv(String motiv) {
		this.motiv = motiv;
	}
	protected String getStareaActuala() {
		return stareaActuala;
	}
	protected void setStareaActuala(String stareaActuala) {
		this.stareaActuala = stareaActuala;
	}
	protected String getStareaDOrita() {
		return stareaDOrita;
	}
	protected void setStareaDOrita(String stareaDOrita) {
		this.stareaDOrita = stareaDOrita;
	}
	public Imbunatatire(Integer idFeedback, Status status, Proiect proiect, User user, Date dataInregistrare,
			Date deadline, String titlu, String descriere, String tipFeedback, String motiv, String stareaActuala,
			String stareaDOrita) {
		super(idFeedback, status, proiect, user, dataInregistrare, deadline, titlu, descriere, tipFeedback);
		this.motiv = motiv;
		this.stareaActuala = stareaActuala;
		this.stareaDOrita = stareaDOrita;
	}
	public Imbunatatire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
