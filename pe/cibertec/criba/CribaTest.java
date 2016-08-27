package pe.cibertec.criba;

import static org.junit.Assert.*;

import org.junit.Test;

public class CribaTest {

	@Test
	public void generarPrimosTest() {
		
		int[] nullArray = GeneradorDePrimos.generarPrimos(0);
		assertEquals(nullArray.length, 0);
		
		int[] arrayVacio = GeneradorDePrimos.generarPrimos(1);
		assertEquals(arrayVacio.length, 0);

		int[] minArray = GeneradorDePrimos.generarPrimos(2);
		assertEquals(minArray.length, 1);
		assertEquals(minArray[0], 2);

		int[] threeArray = GeneradorDePrimos.generarPrimos(3);
		assertEquals(threeArray.length, 2);
		assertEquals(threeArray[0], 2);
		assertEquals(threeArray[1], 3);
		
		int[] centArray = GeneradorDePrimos.generarPrimos(100);
		assertEquals(centArray.length, 25);
		assertEquals(centArray[24], 97);
	}

}
