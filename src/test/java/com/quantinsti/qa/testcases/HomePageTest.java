package com.quantinsti.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.quantinsti.qa.base.TestBase;
import com.quantinsti.qa.pages.HomePage;
import com.quantinsti.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
	}
	
	@Test
	public void HomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home Page Title Not Found");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}