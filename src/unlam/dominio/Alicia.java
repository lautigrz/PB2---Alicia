package unlam.dominio;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Alicia {
	private Double altura;
	private final Double alturaMaxima = 280.0;
	private final Double alturaMinima = 50.0;
	private Double peso;
	private String nombre;
	private Integer edad;
	private Double dinero;

	private Set<Alimentos> supermercado;
	private Set<Alimentos> alimentosComprados;

	public Alicia(Double altura, Double peso, String nombre, Integer edad, Double dinero) {
		this.altura = altura;
		this.peso = peso;
		this.nombre = nombre;
		this.edad = edad;
		this.dinero = dinero;
		this.supermercado = new TreeSet<>(new AlimentosComparator());
		this.alimentosComprados = new TreeSet<>(new AlimentosComparator());
	}

	public Boolean consumir(Integer ID) {
		Alimentos alimento = this.buscarAliemento(ID);
		
		Boolean consumio = false;
		
		if (alimento instanceof Achicadores) {
			consumio = this.achicar(alimento.consumision());
		} else if (alimento instanceof Agrandadores) {
			consumio = this.agrandar(alimento.consumision());
		}
		
		return consumio;
	}

	public Alimentos buscarAliemento(Integer ID) {

		for (Alimentos a : this.alimentosComprados) {

			if (a.getID().equals(ID)) {

				return a;

			}
		}

		return null;
	}

	public Boolean comprarAliemnto(Integer ID) {

		for (Alimentos a : this.supermercado) {

			if (a.getID().equals(ID) && this.dinero >= a.getPrecioAlimento()) {

				this.alimentosComprados.add(a);
				this.descontarDinero(a.getPrecioAlimento());
				return true;
			}

		}
		
		return false;

	}

	public Boolean achicar(Double altura) {
		Double nuevaAltura = this.altura - altura;
		if (nuevaAltura >= alturaMinima) {
			this.altura -= altura;
			return true;
		}
		return false;
	}

	public Boolean agrandar(Double altura) {

		Double nuevaAltura = this.altura + altura;
		if (nuevaAltura <= alturaMaxima) {
			this.altura += altura;
			return true;
		}
		return false;
	}

	public void descontarDinero(Double dinero) {
		this.dinero -= dinero;
	}

	public void agregarAlimento(Alimentos alimento) {
		Alimentos nuevoAlimento = alimento;
		this.supermercado.add(nuevoAlimento);
	}

	public Set<Alimentos> getSupermercado() {
		return supermercado;
	}

	public void setSupermercado(Set<Alimentos> supermercado) {
		this.supermercado = supermercado;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Double getDinero() {
		return dinero;
	}

	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}

}
