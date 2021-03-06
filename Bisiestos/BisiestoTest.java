//
// Instrucciones de compilación:
// javac -cp .:./hamcrest-core-1.3.jar:./junit-4.12.jar MinTest.java
//

import static org.junit.Assert.*; // En este paquete están los métodos assertTrue, assertEquals, assertNull, fail, etc.
import org.junit.*;
import java.util.*;

public class BisiestoTest
{
	private Bisiestos year;

	@Before      // Set up - Called before every test method.
	public void setUp()
	{
		year = new Bisiestos();
	}

	//Test para comprobar que con año negativo se eleva la excepción.
	//Caminos recorridos: (1,2,3)
	@Test (expected = IllegalArgumentException.class) // Este test decora la anotación @Test con la clase de la excepción esperada.
	public void testForNegativeYear()
	{
		year.esBisiesto(-1);
	}

	//Test para comprobar que año 0 no es bisiesto
	//Caminos recorridos: (1,2,4,5,8)
	@Test
	public void testForZeroYear()
	{
		assertFalse(year.esBisiesto(0));
	}

	//Test para comprobar que año no es bisiesto
	//Caminos recorridos: (1,2,4,6,8)
	@Test
	public void testForNoBisiesto()
	{
		assertFalse(year.esBisiesto(2018));
	}

	//Test para comprobar año múltiplo de 4
	//Caminos recorridos: (1,2,4,6,7,8)
	@Test
	public void testMult4()
	{
		assertTrue(year.esBisiesto(4));
	}

	//Test para comprobar año múltiplo de 100 pero no de 400
	//Caminos recorridos: (1,2,4,6,8)
	@Test
	public void testMult100()
	{
		assertFalse(year.esBisiesto(100));
	}

	//Test para comprobar año múltiplo de 400
	//Caminos recorridos: (1,2,4,6,7,8)
	@Test
	public void testMult400()
	{
		assertTrue(year.esBisiesto(400));
	}
}
