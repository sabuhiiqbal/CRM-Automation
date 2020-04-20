package com.crm.qa.base;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RoughContact {
	static WebDriver driver;
	
	public static String selectContactByRowNo(String name) throws InterruptedException {
	String firstPath ="//*[@id='vContactsForm']/table/tbody/tr[";
	String secondPath ="]/td[2]/a";
	WebElement dataInfo = driver.findElement(By.xpath("firstPath+name+secondPath"));
	System.out.println(dataInfo);
	Thread.sleep(1000);
	dataInfo.click();
	//
	//return dataInfo;
	return dataInfo.getText();
		}
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Driver\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		driver.get("https://classic.crmpro.com/");		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.switchTo().frame("mainpanel");
		
		//a[contains(text(),'Contacts')]')]"
		WebElement e = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/a"));
		Actions act = new Actions(driver);
		act.moveToElement(e).build().perform();
		e.click();
		int i=10;
		String startaddress = "//form[@id='vContactsForm']/table/tbody/tr[";
		String afterXpath ="]/td[1]/input";
		driver.findElement(By.xpath(startaddress+i+afterXpath)).click();
	
		
		
		
		//Thread.sleep(1000);
		/*
		 * act.moveToElement(e).build().perform(); List<WebElement> submenu =
		 * driver.findElements(By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/ul")); int length
		 * = submenu.size(); for (int i=0;i<length;i++) {
		 * 
		 * System.out.println(submenu.get(i).getText()); if
		 * (submenu.get(i).getText().contains("New Contact")){ Thread.sleep(1000);
		 * submenu.get(i).click(); }
		 * 
		 * }
		 *///WebElement newContact = driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[4]/ul/li[1]/a"));
		
		//act.moveToElement(e).click().build().perform();
		//act.moveToElement(e).contextClick()
		//WebElement contactLabel = driver.findElement(By.xpath("//td[contains(text(),'Contacts')]"));
		//WebElement e =driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));////a[contains(text(),'Contacts')]
		//String labelText = contactLabel.getText();
		//System.out.println("The label text is "+labelText);
		
		/*
		 * List<WebElement> contactForm =
		 * driver.findElements(By.xpath("//*[@id='vContactsForm']/table/tbody/td"));
		 * for (WebElement info : contactForm) { System.out.println(info.getText()); }
		 */
		//String info = selectContactByRowNo("aaa");
		//String nameInfo = selectContactByRowNo(3);
		
		
		//driver.quit();

		}
		
	
}

