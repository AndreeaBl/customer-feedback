package CustomerF;

public class Status {
	
	private Integer idStatus;
	private String denumire;
	public Integer getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public Status(Integer idStatus, String denumire) {
		super();
		this.idStatus = idStatus;
		this.denumire = denumire;
	}
	@Override
	public String toString() {
		return "Status [idStatus=" + idStatus + ", denumire=" + denumire + "]";
	}
	
	
}
