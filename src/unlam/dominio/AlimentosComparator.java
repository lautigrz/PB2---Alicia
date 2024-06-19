package unlam.dominio;

import java.util.Comparator;

public class AlimentosComparator implements Comparator<Alimentos> {
	 @Override
	    public int compare(Alimentos a1, Alimentos a2) {
	        return a2.getNombreAlimento().compareTo(a1.getNombreAlimento()); // Comparación descendente por nombre
	    }
}
