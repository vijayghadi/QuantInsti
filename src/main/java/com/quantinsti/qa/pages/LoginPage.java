package com.quantinsti.qa.pages;

import com.quantinsti.qa.base.TestBase;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
//import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends TestBase{
	
	//Page Factory - OR
	@FindBy(xpath="//span[contains(text(), 'Login')]")
	WebElement loginBtn;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(), 'Login')]")
	WebElement submitBtn;
	
	@FindBy(xpath="//a[contains(text(), 'Browse Courses')]")
	WebElement browseCourse;
	
	@FindBy(xpath="//*[@id='right-navigation']/ul/div[1]/li[5]/div/div[2]/ul/li[7]/a/span[contains(text(), 'Sentiment Analysis in Trading')]")
	WebElement course;
	
	@FindBy(xpath="//*[@class='course-detail__left-view']/h1")
	WebElement courseName;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/main/div/div[1]/div[2]/div/div[2]/div[1]/div[3]/div[2]/span[2]/span")
	WebElement coursePrice;
	
	@FindBy(xpath="//span[contains(text(), 'Enroll Now')]")
	WebElement EnrollNowBtn;
	
	@FindBy(className="cart-item")
	WebElement cart;
	
	@FindBy(className="cart-count")
	WebElement cartCount;
	
	//Initializing the Page objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public HomePage login(String un, String pass){
		loginBtn.click();
		email.sendKeys(un);
		password.sendKeys(pass);
		submitBtn.click();
		
		return new HomePage();
	}
	
	public void browseCourse(){
		// Browse course and click on course
		Actions builder = new Actions(driver);
		Action mouseOverBrowseCourse = builder.moveToElement(browseCourse)
				.build();
		mouseOverBrowseCourse.perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 20); //here, wait time is 20 seconds
		wait.until(ExpectedConditions.visibilityOf(course));
		course.click();
		
		// Get course name
		Map<String, String> courseText = new HashMap<String, String>();
		courseText.put("Course Name", courseName.getText());
		System.out.println("Course Name :"+courseName.getText());
		
		// Get course price
		String price = coursePrice.getText();
		System.out.println("Course Price :"+price);
		
		// Click on Enroll Now button
		EnrollNowBtn.click();
	}
	
	public void cartPage() {
		// Get count of total courses on Web Page
		List<WebElement> totalCourse = driver.findElements(By.xpath("//div[@class='cart-item']"));
		int courseCount = totalCourse.size();
		System.out.println("total courses : "+courseCount);
		
		// Verify total courses with Cart Count
		String count = cartCount.getText();
		Assert.assertEquals(courseCount, Integer.parseInt(count), "Total course count not matched");
	}
	
}
