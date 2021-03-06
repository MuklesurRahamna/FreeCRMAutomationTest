package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		testUtil=new TestUtil();
		loginPage=new LoginPage();	
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContacts();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		 Assert.assertTrue(contactsPage.verifyContactLabel(),"Contacts label is missing on the page");		
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest() {
		contactsPage.selectContactsByName("Sk R");
	}
	@Test(priority=3)
	public void selectMultipleContactsTest() {
		contactsPage.selectContactsByName("Sk R");
		contactsPage.selectContactsByName("Test Test");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
}
