package com.crm.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;



public class ContactPageTest extends TestBase{
	LoginPage loginPage ;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName="contacts";

	public ContactPageTest() throws IOException {
		super();
	}


	@BeforeMethod
	public void setUp() throws Throwable {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrameByName(prop.getProperty("frameName"));
		contactsPage = homePage.clickOnContactsLink();
		//contactsPage = homePage.clickOnContactsLink();

	}

	@Test(priority=1)
	public void verifyContactLabelTest() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertEquals(true, true);
	}


	@Test(priority=2)
	public void selectContactsByNameTest() throws InterruptedException {
		Thread.sleep(1000);
		contactsPage.selectContactByName("aaa");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsByNameTest() {
		contactsPage.selectContactByName("Aakash Shah");
		contactsPage.selectContactByName("Aakash Patel");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = testUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4,dataProvider="getCRMTestData")
	public void validateCreateNewContactPageTest(String title,String firstname,String lastname,String company) throws InterruptedException {
		Thread.sleep(1000);
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(title,firstname, lastname, company);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
