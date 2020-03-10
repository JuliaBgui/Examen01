package casosPrueba;

import generales.Utilidades;

public class Ejercicio2 {

	public static void filtro_ubicacion() throws InterruptedException {

		String ubicacion = "Capital Federal";
		String eubicacionCF = "//span[@class='filter-name'][contains(text(),'Capital Federal')]";

		try {
			if (Utilidades.esvisible(eubicacionCF, "eubicacionCF")) {
				Utilidades.click(0, eubicacionCF, "eubicacionCF");
				System.out.println("Se filtro por la ubicacion "+ubicacion);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
