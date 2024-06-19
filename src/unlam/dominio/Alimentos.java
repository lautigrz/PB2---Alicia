package unlam.dominio;

public abstract class Alimentos {
	private String nombreAlimento;
	private Double precioAlimento;
	private Integer ID;
	
	public Alimentos(String nombreAlimento, Double precioAlimento, Integer ID) {
		super();
		this.nombreAlimento = nombreAlimento;
		this.precioAlimento = precioAlimento;
		this.ID = ID;
	}
	
	public abstract Double consumision();
	
	public String getNombreAlimento() {
		return nombreAlimento;
	}
	public void setNombreAlimento(String nombreAlimento) {
		this.nombreAlimento = nombreAlimento;
	}
	public Double getPrecioAlimento() {
		return precioAlimento;
	}
	public void setPrecioAlimento(Double precioAlimento) {
		this.precioAlimento = precioAlimento;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	@Override
	public String toString() {
		return "Alimentos [nombreAlimento=" + nombreAlimento + ", precioAlimento=" + precioAlimento + ", ID=" + ID
				+ "]";
	}
	
	
	
}
