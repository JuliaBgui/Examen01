package generales;

import java.awt.Robot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.android.dx.rop.code.Exceptions;
import com.aventstack.extentreports.MediaEntityBuilder;

import configuracion.Configuracion;

public class Utilidades extends Configuracion {
	static String fecha;
	static String hora;
	
	public static void mouseOverCategorias(String opcion, String opxpath) {			
		      WebElement element = driver.findElement(By.linkText(opcion));
		      Actions builder = new Actions(driver);
		      builder.moveToElement(element).perform();		    	
	}
	
	public static void mouseOutCategorias(String Opcion, String opxpath) {
		      WebElement element = driver.findElement(By.tagName("body"));
		      Actions builder = new Actions(driver);
		      builder.moveToElement(element, 0, 0).perform();	
	}
	
	public static void mouseOverCategorian1(String opcion, String opxpath) {		
		 WebElement element = driver.findElement(By.linkText(opcion));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	}
	
	public static void mouseOutCategorian1(String opcion, String opxpath) {		
		WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	}
	
	public static void mouseOverCategorian2(String opcion, String opxpath) {		
		 WebElement element = driver.findElement(By.linkText(opcion));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	}
	
	public static void mouseOutCategorian2(String opcion, String opxpath) {		
		WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	}


	public static void click(int espera, String xpath, String elemento) throws Exception {
		Actions actions = new Actions(driver);
		try {
			try {
				espera(espera);
//				validar(xpath,elemento);
				new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
				actions = new Actions(driver);
				actions.moveToElement(driver.findElement(By.xpath(xpath)));
				Thread.sleep(500);
				actions.click().build().perform();
			} catch (Exception e) {
				e.printStackTrace();
				driver.findElement(By.xpath(xpath)).click();
				System.out.println("Salio x exception click catch1" + xpath);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Salio x exception click catch2" + xpath);
			throw new Exception();

		}
	}

	
	public static void validar(String xpath, String elemento) throws Exception {
		try {
			new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			// logger.pass("Se encontro el elemento: "+elemento);
			elemento = "existe";
			System.out.println("Se encontro el elemento: " + elemento);

		} catch (Exception e) {
			// logger.warning("No se encontro el elemento: "+elemento);
			System.out.println("No se encontro el elemento: " + elemento);
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static Boolean validar2(String xpath, String elemento) throws Exception {
		try {
			new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			// logger.pass("Se encontro el elemento: "+elemento);
			elemento = "existe";
			System.out.println("Se encontro el elemento: " + elemento);

		} catch (Exception e) {
			// logger.warning("No se encontro el elemento: "+elemento);
			System.out.println("No se encontro el elemento: " + elemento);
			e.printStackTrace();
			throw new Exception();
		}
		return true;
	}

	public static String getTitulo() {
		String texto = driver.getTitle();
		return texto;
	}


	public static String getText3(String xpath, String atributo) {
		String texto = "";
		try {
			texto = driver.findElement(By.xpath(xpath)).getAttribute("atributo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return texto;
	}



	private static boolean hasAttribute(WebElement element, String attribute) {
		Boolean result = false;
		try {
			String value = element.getAttribute(attribute);
			if (value != null) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getAtributo(String xpath, String attribute) {
		String texto = "";
		try {
			WebElement Element = driver.findElement(By.xpath(xpath));

			// Verificar si existe el attributo
			if (hasAttribute(Element, attribute)) {
				texto = Element.getAttribute(attribute);
				System.out.println("El elemento tiene una etiqueta:" + texto);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return texto;
	}



	public static void setAtributo(String xpath, String attribute, String valor) {
		try {
			WebElement Element = driver.findElement(By.xpath(xpath));
			if (hasAttribute(Element, attribute)) {
				Element.sendKeys(valor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void espera(long milisegundos) throws InterruptedException {
		Thread.sleep(milisegundos);
	}

	public static void clickEstatico(String xpath, String nombrexpath) throws Exception {
		try {
			Robot r = new Robot();
			new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(By.xpath((xpath))));
			WebElement element = driver.findElement(By.xpath((xpath)));
			r.mouseMove(element.getLocation().getX(), element.getLocation().getY() + 120);
			Thread.sleep(500);
			driver.findElement(By.xpath((xpath))).click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}


	public static void escribir(String texto) {
		new Actions(driver).sendKeys(texto).perform();
	}


	public static void delete(String xpath) {
		driver.findElement(By.xpath(xpath)).clear();
	}

	public static boolean Comparar_Label (String labelxpath, String texto) {		
		String atributo="innerText";
		String label=getAtributo(labelxpath, atributo);
		if(label.contentEquals(texto)) {return true;}
		else {return false;}
	}
	
	public static Boolean esvisible(String xpath, String elemento) throws Exception {
		//seria un existe en el DOM y esta visible
		try {
			new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));			
			System.out.println("Se encontro el elemento: " + elemento+" y es visible");

		} catch (Exception e) {
			// logger.warning("No se encontro el elemento: "+elemento);
			System.out.println("No se encontro el elemento: " + elemento);
			e.printStackTrace();
			throw new Exception();
		}
		return true;
	}

	public static String tomar_Titulo(String xpath) {
		String tituloitemlista="";
		tituloitemlista= Utilidades.getAtributo(xpath, "innerText");
		return tituloitemlista;
	}
	
	
	public static String tomar_Precio(String xpath) {
		String precioitemlista="";
		precioitemlista=Utilidades.getAtributo(xpath, "innerText");
		return precioitemlista;
	}
	
	public static String tomar_Moneda(String xpath){
		String monedaitemlista="";
		monedaitemlista=Utilidades.getAtributo(xpath, "innerText");
		return monedaitemlista;
	}
	
	
}