package casosPrueba;

import configuracion.Configuracion;

public class Caso0 {
	public static void Caso0 () throws InterruptedException{	
		Configuracion.levantarDriver();		
		String urlBase="https://www.mercadolibre.com.ar/";		
		Configuracion.setearUrl(urlBase);
		Thread.sleep(3000);		
	}

}
