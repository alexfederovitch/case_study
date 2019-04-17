package com.perscholas.homeinsurance.automation;

import static org.junit.Assert.*;
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

import org.junit.Test;

public class AutomationTest2 {
	
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
		
		System.out.println("Start login test");
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
		
		WebElement logoutButton = driver.findElement(By.name("logout"));
		logoutButton.click();
				
		driver.quit();
	}

}
