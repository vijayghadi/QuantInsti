package com.quantinsti.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.quantinsti.qa.base.TestBase;
import com.quantinsti.qa.pages.HomePage;
import com.quantinsti.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=2)
	public void browseCourseTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		loginPage.browseCourse();
	}
	
	@Test(priority=3)
	public void cartPageTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		loginPage.browseCourse();
		loginPage.cartPage();
	}
	
	//@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
