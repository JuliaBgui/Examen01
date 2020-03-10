package casosPrueba;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ejercicio4 {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new FirefoxDriver();
		driver.get("http://www.google.com/");
		boolean result;
		try {
			result = clickLastResult();//Error this
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			/* driver.close(); */
		}
		System.out.println("Test " + (result ? "pased." : "failed."));
		if (!result) {
			System.exit(1);
		}
	}

	private static boolean clickLastResult() {
		//Ingresar Busqueda
		driver.findElement(By.name("q")).sendKeys("qa automation\n");
		// Click en Buscar
		driver.findElement(By.name("btnG")).click();
		// Esperar 1 segundo para que se complete la búsqueda
		Thread.sleep(10000);
		//punto y coma
		/*milisegundos. error 10 segundos*/
		// Obtenga el enlace del último resultado de búsqueda y hacerle click
		List<WebElement> links = driver.findElements(By.tagName("a"));
		/*Error tipeo ArrayLIst*/
		/*ArrayList <E> links*/
		/*los tipos de ambos lados de la igualdad deben coincidir*/
		/*List*/
		driver.click(links.get(links.size() -1));
		/*error en metodo click*//*error en parentesis impares*/
	
		return true;
		}

}
