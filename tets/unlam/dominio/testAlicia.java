package unlam.dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class testAlicia {

	@Test
	public void queAlComprarUnAlimentoSeDescuenteElDineroDisponible() {
		Alicia alicia = new Alicia(180.0, 70.0, "Alicia", 15, 3000.0);

		Achicadores achicador = new Achicadores("Jugo", 1500.0, 1);
		Agrandadores agrandador = new Agrandadores("Fruta", 1500.0, 11);

		alicia.agregarAlimento(achicador);
		alicia.agregarAlimento(agrandador);

		Achicadores achicador1 = new Achicadores("paleta", 500.0, 2);
		Agrandadores agrandador1 = new Agrandadores("Naranja", 800.0, 12);

		alicia.agregarAlimento(achicador1);
		alicia.agregarAlimento(agrandador1);

		alicia.comprarAliemnto(1);
		alicia.comprarAliemnto(11);

		Double esperado = 0.0;
		Double actual = alicia.getDinero();

		assertEquals(esperado, actual);
	}

	@Test
	public void queNoSeDxcedaDelDineroDisponible() {
		Alicia alicia = new Alicia(180.0, 70.0, "Alicia", 15, 3000.0);

		Achicadores achicador = new Achicadores("Jugo", 1500.0, 1);
		Agrandadores agrandador = new Agrandadores("Fruta", 1500.0, 11);

		alicia.agregarAlimento(achicador);
		alicia.agregarAlimento(agrandador);

		Achicadores achicador1 = new Achicadores("paleta", 500.0, 2);
		Agrandadores agrandador1 = new Agrandadores("Naranja", 800.0, 12);

		alicia.agregarAlimento(achicador1);
		alicia.agregarAlimento(agrandador1);

		Boolean alimento1 = alicia.comprarAliemnto(1);
		assertTrue(alimento1);
		Boolean alimento2 = alicia.comprarAliemnto(11);
		assertTrue(alimento2);
		Boolean alimento3 = alicia.comprarAliemnto(2);
		assertFalse(alimento3);

	}

	@Test
	public void queAlConsumirUnAlimentoVerificarQueSeAgrande() {
		Alicia alicia = new Alicia(180.0, 70.0, "Alicia", 15, 3000.0);

		Achicadores achicador = new Achicadores("Jugo", 1500.0, 1);
		Agrandadores agrandador = new Agrandadores("Fruta", 1500.0, 11);

		alicia.agregarAlimento(achicador);
		alicia.agregarAlimento(agrandador);

		Achicadores achicador1 = new Achicadores("paleta", 500.0, 2);
		Agrandadores agrandador1 = new Agrandadores("Naranja", 800.0, 12);

		alicia.agregarAlimento(achicador1);
		alicia.agregarAlimento(agrandador1);

		alicia.comprarAliemnto(1);

		alicia.comprarAliemnto(11);

		alicia.consumir(11);

		Double alturaEsperada = 220.0;

		assertEquals(alturaEsperada, alicia.getAltura());

	}

	@Test
	public void queAlConsumirUnAlimentoVerificarQueSeEncoja() {
		Alicia alicia = new Alicia(180.0, 70.0, "Alicia", 15, 3000.0);

		Achicadores achicador = new Achicadores("Jugo", 1500.0, 1);
		Agrandadores agrandador = new Agrandadores("Fruta", 1500.0, 11);

		alicia.agregarAlimento(achicador);
		alicia.agregarAlimento(agrandador);

		Achicadores achicador1 = new Achicadores("paleta", 500.0, 2);
		Agrandadores agrandador1 = new Agrandadores("Naranja", 800.0, 12);

		alicia.agregarAlimento(achicador1);
		alicia.agregarAlimento(agrandador1);

		alicia.comprarAliemnto(1);

		alicia.comprarAliemnto(11);

		alicia.consumir(1);

		Double alturaEsperada = 130.0;

		assertEquals(alturaEsperada, alicia.getAltura());
	}

	@Test
	public void queAlConsumirAlimentosVerificarQueNoSePuedaAgrandarMasDeLaMaxima() {
		Alicia alicia = new Alicia(180.0, 70.0, "Alicia", 15, 8000.0);

		Achicadores achicador = new Achicadores("Jugo", 1500.0, 1);
		Agrandadores agrandador = new Agrandadores("Fruta", 1500.0, 11);

		alicia.agregarAlimento(achicador);
		alicia.agregarAlimento(agrandador);

		Achicadores achicador1 = new Achicadores("paleta", 500.0, 2);
		Agrandadores agrandador1 = new Agrandadores("Naranja", 800.0, 12);
		Agrandadores agrandador2 = new Agrandadores("Pera", 100.0, 13);

		alicia.agregarAlimento(achicador1);
		alicia.agregarAlimento(agrandador1);
		alicia.agregarAlimento(agrandador2);

		alicia.comprarAliemnto(1);

		alicia.comprarAliemnto(11);
		alicia.comprarAliemnto(12);
		alicia.comprarAliemnto(13);

		alicia.consumir(11);
		alicia.consumir(12);

		assertFalse(alicia.consumir(13));

	}
	
	@Test
	public void  queAlConsumirAlimentosVerificarQueNoSeAchiceMenosQueLaMaxima() {
		Alicia alicia = new Alicia(180.0, 70.0, "Alicia", 15, 8000.0);

		Achicadores achicador = new Achicadores("Jugo", 1500.0, 1);
		Agrandadores agrandador = new Agrandadores("Fruta", 1500.0, 11);

		alicia.agregarAlimento(achicador);
		alicia.agregarAlimento(agrandador);

		Achicadores achicador1 = new Achicadores("paleta", 500.0, 2);
		Achicadores agrandador1 = new Achicadores("Naranja", 800.0, 3);
		Agrandadores agrandador2 = new Agrandadores("Pera", 100.0, 13);

		alicia.agregarAlimento(achicador1);
		alicia.agregarAlimento(agrandador1);
		alicia.agregarAlimento(agrandador2);

		alicia.comprarAliemnto(1);

		alicia.comprarAliemnto(2);
		alicia.comprarAliemnto(3);

		alicia.consumir(1);
		alicia.consumir(2);

		assertFalse(alicia.consumir(3));
	}
	
	@Test
	public void verificarQueLaColeccionQuedeOrdenadaDeManeraDescendente() {
		
        Alicia alicia = new Alicia(180.0, 70.0, "Alicia", 15, 8000.0);

      
        Achicadores achicador = new Achicadores("Jugo", 1500.0, 1);
        Agrandadores agrandador = new Agrandadores("Fruta", 1500.0, 11);
        alicia.agregarAlimento(achicador);
        alicia.agregarAlimento(agrandador);

        Achicadores achicador1 = new Achicadores("Paleta", 500.0, 2);
        Achicadores agrandador1 = new Achicadores("Naranja", 800.0, 3);
        Agrandadores agrandador2 = new Agrandadores("Pera", 100.0, 13);
        alicia.agregarAlimento(achicador1);
        alicia.agregarAlimento(agrandador1);
        alicia.agregarAlimento(agrandador2);

        
        Set<Alimentos> alimentosOrdenados = alicia.getSupermercado();

       
        List<String> nombresOrdenados = new ArrayList<>();
        for (Alimentos alimento : alimentosOrdenados) {
            nombresOrdenados.add(alimento.getNombreAlimento());
        }

        List<String> nombresEsperados = List.of("Pera", "Paleta", "Naranja", "Jugo", "Fruta");
        assertEquals(nombresEsperados, nombresOrdenados);

	}


}
