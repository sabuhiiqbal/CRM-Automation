package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement userNameLabel;
	@CacheLookup
	

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	@CacheLookup
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	@CacheLookup
	

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	@CacheLookup

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;


	// Initializing the Page Objects:
	public HomePage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() throws IOException{
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public void clickOnNewContactLink() throws InterruptedException {
		Actions actions = new Actions(driver);
		
		actions.moveToElement(contactsLink).moveToElement(newContactLink).click().build().perform();
		Thread.sleep(1000);
		newContactLink.click();
		
		
		
		
	}

}
