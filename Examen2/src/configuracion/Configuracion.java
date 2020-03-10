package configuracion;

import java.io.File;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Configuracion {
public static WebDriver driver;

//@BeforeTest
	//@SuppressWarnings("deprecation")
	public static void levantarDriver() {
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addExtensions(new File("extensiones\\ChroPath\\5.0.7_0.crx"));
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		driver = new ChromeDriver(desiredCapabilities);
	}
	
	public static void setearUrl(String urlBase) {
		String url=urlBase;
		driver.get(url);
		driver.manage().window().maximize();
	}
}
