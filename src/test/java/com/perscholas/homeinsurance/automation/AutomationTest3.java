package com.perscholas.homeinsurance.automation;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.homeinsurance.DAO.OracleConnection;

public class AutomationTest3 {

	private static WebDriver driver;
	private static Connection conn;
	
	@BeforeClass
	public static void setUp() throws ClassNotFoundException, IOException, SQLException {

		OracleConnection orcl = new OracleConnection();
		Connection conn = orcl.getConnection();
		System.out.println("Connected to database.");
	}
	
	@Test
	public void test() {
		
		System.out.println("Start Get Quote test");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		String url = "http://localhost:8080/homeinsurance_case_study/";
		driver.get(url);
		
	
		WebElement username = driver.findElement(By.name("userName"));
		username.sendKeys("testUser");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("TestCase123");
		
		WebElement loginButton = driver.findElement(By.name("login"));
		loginButton.click();
		
		WebElement getQuote = driver.findElement(By.name("getQuote"));
		getQuote.click();
		
		Select residenceType = new Select(driver.findElement(By.name("residenceType")));
		residenceType.selectByIndex(3);
		
		WebElement addressLine1 = driver.findElement(By.name("addressLine1"));
		addressLine1.sendKeys("2525 Murworth");
		
		WebElement addressLine2 = driver.findElement(By.name("addressLine2"));
		addressLine2.sendKeys("Suite 400");
		
		WebElement state = driver.findElement(By.cssSelector("#state"));
		state.sendKeys("TX");
		
		WebElement locationCity = driver.findElement(By.cssSelector("#city"));
		locationCity.sendKeys("Rosenberg");
		
		WebElement zipCode = driver.findElement(By.name("zip"));
		zipCode.sendKeys("77022");
		
		Select residenceUse = new Select(driver.findElement(By.name("residenceUse")));
		residenceUse.selectByIndex(2);
		
		WebElement continueButton = driver.findElement(By.name("submit"));
		continueButton.click();
		
		WebElement firstName = driver.findElement(By.name("firstName"));
		firstName.sendKeys("George");
		
		WebElement lastName = driver.findElement(By.name("lastName"));
		lastName.sendKeys("Lopez");
		
		WebElement dob = driver.findElement(By.name("dob"));
		dob.sendKeys("04051985");
		
		WebElement isRetired = driver.findElement(By.id("r1"));
		isRetired.click();
		
		WebElement ssn = driver.findElement(By.name("ssn"));
		ssn.sendKeys("425369874");
		
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("something@pretendmail.com");
		
		WebElement continueButton2 = driver.findElement(By.name("submit"));
		continueButton2.click();
		
		WebElement marketValue = driver.findElement(By.name("marketValue"));
		marketValue.sendKeys("90000");
		
		WebElement yearBuilt = driver.findElement(By.name("yearBuilt"));
		yearBuilt.sendKeys("1980");
		
		WebElement squareFootage = driver.findElement(By.name("squareFootage"));
		squareFootage.sendKeys("1600");
		
		Select dwellingType = new Select(driver.findElement(By.name("dwellingType")));
		dwellingType.selectByIndex(0);
		
		Select roofMaterial = new Select(driver.findElement(By.name("roofMaterial")));
		roofMaterial.selectByIndex(2);
		
		Select garage = new Select(driver.findElement(By.name("garage")));
		garage.selectByIndex(4);
		
		Select fullBath = new Select(driver.findElement(By.name("fullBath")));
		fullBath.selectByIndex(2);
		
		Select halfBath = new Select(driver.findElement(By.name("halfBath")));
		halfBath.selectByIndex(1);
		
		WebElement isPool = driver.findElement(By.id("sp1"));
		isPool.click();
		
		WebElement continueButton3 = driver.findElement(By.name("submit"));
		continueButton3.click();
		
		WebElement continueButton4 = driver.findElement(By.name("submit"));
		continueButton4.click();
		
		WebElement buy1 = driver.findElement(By.cssSelector("body > form > table > tbody > tr:nth-child(2) > td > button"));
		buy1.click();
		
		WebElement policyStart = driver.findElement(By.name("policyStart"));
		policyStart.sendKeys("04152019");
		
		WebElement read = driver.findElement(By.id("read"));
		read.click();
		
		WebElement continueButton5 = driver.findElement(By.name("submit"));
		continueButton5.click();
				
		driver.quit();
	}

}
