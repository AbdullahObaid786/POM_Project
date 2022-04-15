package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {
	WebDriver driver ;
	 
	@Test
	public void validUserShouldBeAbleToLogin () {
		  driver = BrowserFactory.init();
		  // We need to use PageFactory to create object for LoginPage class
		  LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		  loginPage.insertUserName("demo@techfios.com");
		  loginPage.insertPassword("abc123");
		  loginPage.clickSigninButton(); 
		  
		  DashboardPage dashbaordPage = PageFactory.initElements(driver, DashboardPage.class);
		  dashbaordPage.verifyDashboardPage();
		  BrowserFactory.tearDown();
  	}
}
