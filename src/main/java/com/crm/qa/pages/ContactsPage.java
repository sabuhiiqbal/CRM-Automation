package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	


	@FindBy(xpath ="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	@CacheLookup

	@FindBy(id="first_name")
	WebElement firstName;
	@CacheLookup

	@FindBy(id="surname")
	WebElement lastName;
	@CacheLookup

	@FindBy(name="client_lookup")
	WebElement company;
	@CacheLookup

	@FindBy(xpath ="//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")
	WebElement saveBtn;
	@CacheLookup

	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement  ContactMenu;
	@CacheLookup
	
	@FindBy(name="title")
	WebElement titleDropDown;
	



	// Initializing the Page Objects:
	public ContactsPage()throws IOException {
		PageFactory.initElements(driver, this);
	}


	public boolean verifyContactsLabel(){
		boolean status =contactsLabel.isDisplayed();
		return status;

	}


	public void selectContactByName(String name){
		/*
		 * String beforeXpath
		 * ="//form[@id='vContactsForm']/table[@class='datacard']/tbody//following-sibling::td[@class='datalistrow']/a[@context='contact'][";
		 * String main = "contains(text(),"; String afterXpath ="'"+name+"'" +")]";
		 * String mainpath=beforeXpath+main+afterXpath; System.out.println(driver);
		 * WebElement contactInfo = driver.findElement(By.xpath(mainpath));
		 */
		
		////table[@class='datacard']/tbody/tr[8]/td/input[@type='checkbox'][@name='contact_id']
		
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		
		
	}



	public void createNewContact(String title,String ftName, String ltName, String comp) throws InterruptedException{
		//WebElement e = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/a"));
		Thread.sleep(1000);
		Select select = new Select(titleDropDown);
		
		select.selectByVisibleText(title);

		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();

	}




}

