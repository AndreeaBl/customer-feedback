package CustomerF;

public class Bug extends Feedback {

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
