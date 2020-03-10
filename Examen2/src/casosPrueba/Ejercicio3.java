package casosPrueba;

import generales.Utilidades;

public class Ejercicio3 {
	public static void tituloyprecio(String tituloesperado, String precioesperado, String monedaesperado)throws InterruptedException{
		Thread.sleep(2000);		
		String etitulo="//h1[@class='item-title__primary ']";
		String emoneda="//span[@class='price-tag-symbol']";
		String eprecio="//fieldset[contains(@class,'item-price')]//span[@class='price-tag-fraction']";
		
		String tituloobtenido="";
		String monedaobtenido="";
		String precioobtenido="";
		
		//Obtener titulo
		tituloobtenido=Utilidades.tomar_Titulo(etitulo);
		System.out.println("El titulo obtenido es: "+tituloobtenido);
		//obtener moneda
		monedaobtenido=Utilidades.tomar_Moneda(emoneda);
		System.out.println("La moneda obtenido es: "+monedaobtenido);
		//obtener precio
		precioobtenido=Utilidades.tomar_Precio(eprecio);
		System.out.println("El precio obtenido es: "+precioobtenido);
	//Verificar Titulo
	if(tituloobtenido.contentEquals(tituloesperado)){

		System.out.println("El titulo "+tituloobtenido+"es correcto");
	}
	else
	{
		System.out.println("El titulo "+tituloobtenido+"es INcorrecto");
	}

	//Verificar Moneda
		if(monedaobtenido.contentEquals(monedaesperado)){

			System.out.println("La moneda "+monedaobtenido+"es correcta");
		}
		else
		{
			System.out.println("La moneda "+monedaobtenido+"es INcorrecta");
		}
	
	//Verificar Precio
	if(precioobtenido.contentEquals(precioesperado))
	{
		System.out.println("El precio "+precioobtenido+"es correcto");
	}
	else
	{
		System.out.println("El precio "+precioobtenido+"es INcorrecto");
	}

	}


}
