package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static WebDriver driver;
	static String browser = "chrome";
	static String url = "https://www.techfios.com/billing/?ng=admin/";
	
	public static WebDriver init () {
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "Driver2\\chromedriver.exe");
			driver = new ChromeDriver ();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "Driver2\\geckodriver.exe");
			driver = new FirefoxDriver ();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public static void tearDown () {
		driver.close();
		driver.quit();
	}
	
}
