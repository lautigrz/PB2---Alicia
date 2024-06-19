package unlam.dominio;

public class Achicadores extends Alimentos implements Comparable<Achicadores> {
	
	private final Double ACHICA = 50.0;
	
	public Achicadores(String nombreAlimento, Double precioAlimento, Integer ID) {
		super(nombreAlimento, precioAlimento, ID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double consumision() {
		// TODO Auto-generated method stub
		return ACHICA;
	}
	
	  @Override
	    public int compareTo(Achicadores otro) {
	        // Comparar por nombre descendente
	        return otro.getNombreAlimento().compareTo(super.getNombreAlimento());
	    }

}
