package com.perscholas.homeinsurance.automation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.homeinsurance.DAO.OracleConnection;

import static org.junit.Assume.assumeTrue;

public class AutomationTest {

	private static WebDriver driver;
	private static Connection conn;

	@BeforeClass
	public static void setUp() throws ClassNotFoundException, IOException, SQLException {
//		System.out.println("Start login test");
//		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//
//		driver = new ChromeDriver();
//		wait = new WebDriverWait(driver, 10);
//		screenshotFolder = "Screewnshots" + LocalDateTime.now();

		OracleConnection orcl = new OracleConnection();
		conn = orcl.getConnection();
		System.out.println("Connected to database.");
	}

	@Test
	public void registerTest() throws IOException {

		System.out.println("Start login test");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		String url = "http://localhost:8080/homeinsurance_case_study/";
		driver.get(url);
		
		WebElement registerButton = driver.findElement(By.id("register"));
		registerButton.click();
		
		WebElement username = driver.findElement(By.name("userName"));
		username.sendKeys("testUser");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("TestCase123");
		
		WebElement adminRole = driver.findElement(By.name("adminRole"));
		adminRole.sendKeys("admin");
		
		WebElement registerButton2 = driver.findElement(By.name("register"));
		registerButton2.click();
		
		driver.quit();

		/*
		 * WebElement logoutBtn =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * cssSelector("body > a"))); action.moveToElement(logoutBtn).perform();
		 * logoutBtn.click();
		 */

	}

}
