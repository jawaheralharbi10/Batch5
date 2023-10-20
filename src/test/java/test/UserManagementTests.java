package test;

import java.time.Duration;




import pages.LoginPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;

public class UserManagementTests {
public static void main(String[] args) {
	invalidEmailLoginTest();
}
	static BrowserUtils utils;
	static LoginPage loginpage;

	public static void invalidEmailLoginTest() {
	utils = new BrowserUtils();
	loginpage = new LoginPage();
	// invalid email Login test
	// go to crater
	Driver.getDriver().get(TestDataReader.getProperty("appurl"));
	Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	Driver.getDriver().manage().window().maximize();
	
	utils.waitForElementToBeVisible(loginpage.login_page_email_box);
	// click on Login button without filling out credential fields
	loginpage.login_page_login_btn.click();
	
	// then verify there are 2 fields required messages display
	utils.waitForAllElementsToBeVisible(loginpage.login_page_fieldRequired_Messages);
	if(loginpage.login_page_fieldRequired_Messages.size() == 2) {
		System.out.println("There are 2 required field messages displayed");
	}else {
		System.out.println("Something is wrong with required field messages");
	}
	
	// enter invalid email account@primetechschool.com and valid password primetech@school
	utils.sendkeysWithActionClass(loginpage.login_page_email_box , "account@primetechschool.com");
	 
	//loginpage.login_page_email_box.sendKeys("account@primetechschool.com");

	utils.sendkeysWithActionClass(loginpage.login_page_password_box, TestDataReader.getProperty("password"));
	// click login btn
	loginpage.login_page_login_btn.click();
	// then verify that an error message "These credential do not match our records." displays
	utils.waitForElementToBeVisible(loginpage.login_page_invalidlogin_message);
	if(loginpage.login_page_invalidlogin_message.isDisplayed()) {
		System.out.println("Credential invalid Error message displayed");
	}else {
		System.out.println("Credential invalid Error message displayed");
	}
}	
	
	
	
// Invalid Password login Tests
// go to crater
// click on Login button without filling out credential fields
// then verify there are 2 fields required messages display
// enter valid email accounts@primetechschool.com and invalid password primeschool
// Loginpage.login_page_email_box.sendKeyes("accounts@primetechschool.com");
// Loginpage.login_page_password_box.sendKeys(TestDataReader.getProperty("password"));
// click login btn
// then verify that an error message "These credential do not match our records." displays
}
