package TestNG;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils; 
public class AppTest {
	ChromeDriver driver = new ChromeDriver();
	@BeforeTest
	public void launchBrowser() {
		driver.get("https://automationexercise.com/");
	}
	@BeforeMethod
	public void ValidateHomePage() {
		WebElement homepage = driver.findElement(By.cssSelector(".fa-home"));
		if (homepage.isDisplayed()) {
			System.out.println("Home page displayed");
		}
		else {
			System.out.println("Home not displayed");
		}
	}
	@Test
	@Parameters({"username","emailID"})
	public void signin(String username, String emailID) {
		System.out.println("inside signin");
		driver.findElement(By.className("fa-lock")).click();
		driver.findElement(By.xpath("//input[@name='name'][@data-qa='signup-name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='email'][@data-qa='signup-email']")).sendKeys(emailID); 
							
		driver.findElement(By.xpath("//button[@type='submit'][@class='btn btn-default'][@data-qa='signup-button']")).click();
		String getValidateText = driver.findElement(By.xpath("//div[@class='login-form']/h2[@class='title text-center']")).getText();
		System.out.println("signup page text : "+getValidateText);
		driver.findElement(By.id("id_gender1")).click();
	}
	
	@AfterTest
	public void closeBroswer() {
		driver.quit();
	}
}
