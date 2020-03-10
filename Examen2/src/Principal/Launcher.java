package Principal;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import casosPrueba.Caso0;
import casosPrueba.Ejercicio1;
import casosPrueba.Flujos;
import casosPrueba.Menu;

public class Launcher {

	public static void main(String[] args) throws InterruptedException {
		
		//Flujos de Navegacion
		List<Flujos> listaflujos= new ArrayList<Flujos>();
		Flujos flujo1=new Flujos();
		flujo1.setItemMenu("Categor�as");
		flujo1.setCategorian1("Hogar y Electrodom�sticos");
		flujo1.setCategorian2("Climatizaci�n");
		listaflujos.add(flujo1);
		Flujos flujo2=new Flujos();
		flujo2.setItemMenu("Categor�as");
		flujo2.setCategorian1("Tecnolog�a");
		flujo2.setCategorian2("Celulares y Smartphones");
		listaflujos.add(flujo2);
		Flujos flujo3=new Flujos();
		flujo3.setItemMenu("Categor�as");
		flujo3.setCategorian1("Belleza y Cuidado Personal");
		flujo3.setCategorian2("Perfumes Importados");
		listaflujos.add(flujo3);
		Flujos flujo4=new Flujos();
		flujo4.setItemMenu("Categor�as");
		flujo4.setCategorian1("Herramientas e Industria");
		flujo4.setCategorian2("Industria Textil");
		listaflujos.add(flujo4);
		Flujos flujo5=new Flujos();
		flujo5.setItemMenu("Categor�as");
		flujo5.setCategorian1("Juguetes y Beb�s");
		flujo5.setCategorian2("Cuarto del Beb�");
		listaflujos.add(flujo5);
		
		

		

for (Flujos flujo : listaflujos) {			
			//Levantar Driver y setear URL
			Caso0.Caso0();	
			System.out.println("Flujo" + " " + flujo.getItemMenu() + " " + flujo.getCategorian1() + " " + flujo.getCategorian2());
			System.out.println("****************");
			Menu.menu(flujo.getItemMenu(), flujo.getCategorian1(), flujo.getCategorian2());
		}
		

		
		
	}

}
