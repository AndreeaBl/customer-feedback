package CustomerF;

public class User {
	private Integer idUser;
	private Integer echipa;
	private String numePrescurtat;
	private String numePrenume;
	private String mail;
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public Integer getEchipa() {
		return echipa;
	}
	public void setEchipa(Integer echipa) {
		this.echipa = echipa;
	}
	public String getNumePrescurtat() {
		return numePrescurtat;
	}
	public void setNumePrescurtat(String numePrescurtat) {
		this.numePrescurtat = numePrescurtat;
	}
	public String getNumePrenume() {
		return numePrenume;
	}
	public void setNumePrenume(String numePrenume) {
		this.numePrenume = numePrenume;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public User(Integer idUser, Integer echipa, String numePrescurtat, String numePrenume, String mail) {
		super();
		this.idUser = idUser;
		this.echipa = echipa;
		this.numePrescurtat = numePrescurtat;
		this.numePrenume = numePrenume;
		this.mail = mail;
	}
	public User() {
		super();
	}
	
	
}
