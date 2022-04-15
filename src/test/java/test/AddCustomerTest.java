package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {
WebDriver driver;

@Test
public void validUserShouldBeAbleToCreateCustomer () {
	driver = BrowserFactory.init();
	
	LoginPage login = PageFactory.initElements(driver, LoginPage.class);
	login.insertUserName("demo@techfios.com");
	login.insertPassword("abc123");
	login.clickSigninButton();
	
	DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
	dashboardPage.verifyDashboardPage();
	dashboardPage.clickCustomerMenuButton();
	dashboardPage.ClickAddCustomerMenuButton();
	
	AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
	addCustomerPage .verifyAddContactPage();
	addCustomerPage.insertFullName("Selenium October");
	addCustomerPage.selectCompanyDropDown("Techfios");
}
}
