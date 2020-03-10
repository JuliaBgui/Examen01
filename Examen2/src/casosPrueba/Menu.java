package casosPrueba;

import generales.Utilidades;
public class Menu {
	public static void menu(String menuCategorias, String categn1, String categn2) throws InterruptedException {
		//Elementos
		String eMenuCategorias="//a[@class='nav-menu-categories-link']";
		String epickerCategorias="//a[contains(@class,'nav-menu-item-link nav-menu-categories-link')]";
		String eListCateg="//section[@class='nav-categs-departments']";
		
		String eCategorian1="//a[@class='nav-categs-departments__selected']";
				//+ "//a[contains(text(),'"+categn1+"')]";
		String eCategorian2="//a[contains(text(),'"+categn2+"')]";
		
		//
		String categorias=menuCategorias;
		String categorianivel1=categn1;
		String categorianivel2=categn2;
		String tituloesperado="";
		String precioesperado="";
		String monedaesperado="";
		
		
		
		//Menu-Categorias
		try {
			
			Utilidades.mouseOverCategorias(categorias, eMenuCategorias);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		Thread.sleep(1000);
		try {
			Utilidades.click(0, eMenuCategorias, "eMenuCategorias");
			System.out.println("Se realizo click sobre Categorias");
		} catch (Exception e1) {
			e1.printStackTrace();
		}		
		
		Thread.sleep(1000);
		//Categorian1 
		Utilidades.mouseOverCategorian1(categn1, eCategorian1);
		try {
			Utilidades.click(0, eCategorian1, "eCategorian1");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			Utilidades.click(0, eCategorian1, "eCategorian1");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		Thread.sleep(1000);
		//Categorian2
		Utilidades.mouseOverCategorian2(categn2, eCategorian2);
		try {
			Utilidades.click(0, eCategorian2, "eCategorian2");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Thread.sleep(4000);
		
		String lista="//ol[@id='searchResults']";
		String size=Utilidades.getAtributo(lista, "childElementCount");
		
		//Lista de elementos de la Categoria/categn1/categn2
		//ej. Categorías/Hogar y Electrodomésticos/Climatización
		System.out.println("La lista de elementos tiene "+size+"items");
		
		//Verificacion Titulo y Resultado
		Ejercicio1.tituloyresult(categn2);
		//Verificacion de filtrado x ubicacion Capital Federal
		Ejercicio2.filtro_ubicacion();
	
		

		
		//Generacion Item al azar
		int numeroAleatorio = (int) (Math.random()* new Integer(size)+1);		
		String itemlista="//ol[@id='searchResults']//li["+numeroAleatorio+"]";
		Thread.sleep(2000);
		//obtener zona clickeable ejemplo titulo del item al azar
		String eitemlistatitulo=itemlista+"//span[@class='main-title']";
		String eitemlistaprecio=itemlista+"//span[@class='price__fraction']";
		String emonedaesperado=itemlista+"//span[@class='price__symbol']";
		Thread.sleep(2000);
		//Obtener Titulo, precio y moneda del item al azar
		tituloesperado=Utilidades.tomar_Titulo(eitemlistatitulo);
		precioesperado=Utilidades.tomar_Precio(eitemlistaprecio);
		monedaesperado=Utilidades.tomar_Moneda(emonedaesperado);
		System.out.println("El titulo esperado es: "+tituloesperado);
		System.out.println("El precio esperado es: "+precioesperado);
		System.out.println("El moneda esperado es: "+monedaesperado);
		
						
		try {
			//Seleccionar Item al azar
			Utilidades.click(0, eitemlistatitulo, "");
			Thread.sleep(2000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Verificar Titulo, precio y moneda del Item al azar seleccionado
		Ejercicio3.tituloyprecio(tituloesperado,precioesperado, monedaesperado);
	}

}
