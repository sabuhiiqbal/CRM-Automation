package com.crm.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RoughDynamicTable {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		/*
		 * WebDriverManager.chromedriver().setup();
		 * System.setProperty("webdriver.chrome.driver",
		 * "src\\test\\resources\\Driver\\chromedriver.exe"); driver = new
		 * ChromeDriver(); driver.get("https://www.w3schools.com/html/html_tables.asp");
		 * driver.manage().window().maximize();
		 */
	    String name ="aaa";
	    String expected ="//form[@id='vContactsForm']/table[@class='datacard']/tbody//following-sibling::td[@class='datalistrow']/a[@context='contact'][contains(text(),'aaa')]";
	    String beforeXpath ="//form[@id='vContactsForm']/table[@class='datacard']/tbody//following-sibling::td[@class='datalistrow']/a[@context='contact'][";
		String main	= "contains(text(),";
	    String afterXpath ="'"+name+"'" +")]";
	    String mainpath=beforeXpath+main+afterXpath;
	    System.out.println(mainpath);
	    if (mainpath.equals(expected)) {
	    	System.out.println(true);
	    	
	    }
	    
	    	else
	    	{
	    		System.out.println(false);
	    	}
	   //String status = Assert.assertTrue("mainpath", expected);
	
	//driver.findElement(By.xpath("beforeXpath"));
}
}