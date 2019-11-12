package CustomerF;

public class Echipa {
	private Integer idEchipa;
	private String denumireEchipa;
	private String descriereEchipa;
	private String tipEchipa;
	public Integer getIdEchipa() {
		return idEchipa;
	}
	public void setIdEchipa(Integer idEchipa) {
		this.idEchipa = idEchipa;
	}
	public String getDenumireEchipa() {
		return denumireEchipa;
	}
	public void setDenumireEchipa(String denumireEchipa) {
		this.denumireEchipa = denumireEchipa;
	}
	public String getDescriereEchipa() {
		return descriereEchipa;
	}
	public void setDescriereEchipa(String descriereEchipa) {
		this.descriereEchipa = descriereEchipa;
	}
	public String getTipEchipa() {
		return tipEchipa;
	}
	public void setTipEchipa(String tipEchipa) {
		this.tipEchipa = tipEchipa;
	}
	public Echipa(Integer idEchipa, String denumireEchipa, String descriereEchipa, String tipEchipa) {
		super();
		this.idEchipa = idEchipa;
		this.denumireEchipa = denumireEchipa;
		this.descriereEchipa = descriereEchipa;
		this.tipEchipa = tipEchipa;
	}
	public Echipa() {
		super();
	}
	
	
}
