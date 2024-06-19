package unlam.dominio;

public class Agrandadores extends Alimentos implements Comparable<Agrandadores>{
	private final Double AGRANDA = 40.0;

	public Agrandadores(String nombreAlimento, Double precioAlimento, Integer ID) {
		super(nombreAlimento, precioAlimento, ID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double consumision() {
		// TODO Auto-generated method stub
		return AGRANDA;
	}
	
	  @Override
	    public int compareTo(Agrandadores otro) {
	        // Comparar por nombre descendente
	        return otro.getNombreAlimento().compareTo(super.getNombreAlimento());
	    }
}
