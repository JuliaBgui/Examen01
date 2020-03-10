package casosPrueba;

import generales.Utilidades;


import java.util.Map;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Map;


public class Ejercicio1 {	
	public static void tituloyresult(String titulo) throws InterruptedException {	
	String etitulo="//h1[contains(@class,'breadcrumb__title')]";
	String eresultado="//div[contains(@class,'quantity-results')]";
	
	String tituloesperado=titulo;//CategoriaNivel3;
	String tituloobtenido="";
	String atributo="innerText";

	// Verificar Titulo
	tituloobtenido=Utilidades.getAtributo(etitulo, atributo);
	if (tituloobtenido.contentEquals(tituloesperado)) 
	{
		System.out.println("El Titulo "+tituloobtenido+"es correcto");
		//logger.pass("El titulo es correcto");
		//Screenshots.Screenshot("Titulo");	
	}
	else
	{
		System.out.println("El Titulo "+tituloobtenido+"es INcorrecto");
		//logger.fail("El titulo NO es correcto");
		//Screenshots.ScreenshotError("Titulo incorrecto, el titulo correcto es: "+tituloesperado);
	}

	
	//Verificar resultados
	try {
		if (Utilidades.esvisible(eresultado, "eresultado"))
		{		
			System.out.println("El resultado "+tituloobtenido+"es visible");
			//logger.pass("El resultado es correcto");
			//Screenshots.Screenshot("Resultado");	
		}
		else
		{
			System.out.println("El resultado "+tituloobtenido+"NO es visible");
			//logger.fail("El resultado NO es correcto");
			//Screenshots.ScreenshotError("Resultado incorrecto, el resultado correcto es: "+tituloesperado);
		}
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
}
}
