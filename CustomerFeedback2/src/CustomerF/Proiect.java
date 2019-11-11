package CustomerF;

public class Proiect {
	private Integer idProiect;
	private Echipa echipa;
	private String denumire;
	private String tipProiect;
	public Integer getIdProiect() {
		return idProiect;
	}
	public void setIdProiect(Integer idProiect) {
		this.idProiect = idProiect;
	}
	public Echipa getEchipa() {
		return echipa;
	}
	public void setEchipa(Echipa echipa) {
		this.echipa = echipa;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public String getTipProiect() {
		return tipProiect;
	}
	public void setTipProiect(String tipProiect) {
		this.tipProiect = tipProiect;
	}
	public Proiect(Integer idProiect, Echipa echipa, String denumire, String tipProiect) {
		super();
		this.idProiect = idProiect;
		this.echipa = echipa;
		this.denumire = denumire;
		this.tipProiect = tipProiect;
	}
	public Proiect() {
		super();
	}
	
	

}
