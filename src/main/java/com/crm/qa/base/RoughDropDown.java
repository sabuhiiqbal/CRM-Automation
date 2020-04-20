package com.crm.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RoughDropDown {
	static WebDriver driver;


	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Driver\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		driver.get("https://classic.crmpro.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.switchTo().frame("mainpanel");

		//a[contains(text(),'Contacts')]')]"
		WebElement e = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/a"));
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(e).build().perform();
		WebElement newContactLink = driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[4]/a/parent::li/ul/li/a[@title='New Contact']"));
		newContactLink.click();

		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText("Miss");
		WebElement firstName = driver.findElement(By.id("first_name"));
		
		WebElement lastName = driver.findElement(By.id("surname"));
		lastName.sendKeys("John");
		WebElement company = driver.findElement(By.name("client_lookup"));
		company.sendKeys("hekllo");
		
		
		
		
		
		
		
		
		
		
		
	}

}

