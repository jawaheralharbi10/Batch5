package test;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.ItemsPage;
import pages.LoginPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;

public class ItemsManagement_steps {
	
	BrowserUtils utils = new BrowserUtils();
	LoginPage loginpage = new LoginPage();
	DashboardPage dashboard = new DashboardPage();
	ItemsPage item_page = new ItemsPage();
	
	static String itemName;
	
	@Given("As An entity user, I am logged in")
	public void as_an_entity_user_i_am_logged_in() {
	   Driver.getDriver().get(TestDataReader.getProperty("appurl"));
	   Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   Driver.getDriver().manage().window().maximize();
	   utils.waitForElementToBeVisible(loginpage.login_page_email_box);
	   utils.sendkeysWithActionClass(loginpage.login_page_email_box, TestDataReader.getProperty("email"));
	   utils.sendkeysWithActionClass(loginpage.login_page_password_box, TestDataReader.getProperty("password"));
	   loginpage.login_page_login_btn.click();
	   utils.waitForElementToBeVisible(dashboard.loggedinSuccess_msg);
	   Assert.assertTrue(dashboard.loggedinSuccess_msg.isDisplayed());
	}
	
	@Given("I navigate to Items tab")
	public void i_navigate_to_items_tab() {
	 dashboard.items_tab.click();
	 utils.waitForElementToBeVisible(item_page.items_page_item_headerText);
	 Assert.assertTrue(item_page.items_page_item_headerText.isDisplayed());
	}
	@When("I click on the Add Item button")
	public void i_click_on_the_add_item_button() {
	   item_page.items_page_addItems_btn.click();
	   
	   
	}
	@Then("I should be on the item input page")
	public void i_should_be_on_the_item_input_page() {
		utils.waitForElementToBeVisible(item_page.items_input_page_newItem_text);
		Assert.assertTrue(item_page.items_input_page_newItem_text.isDisplayed());   
	}
	@When("I provide item information name {string}, price {string}, unit {string}, and description {string}")
	public void i_provide_item_information_name_price_unit_and_description(String Name, String price, String unit, String description) {
	    itemName = Name + utils.randomNumber();
		item_page.items_input_page_name_box.sendKeys(itemName);
	    item_page.items_input_page_price_box.sendKeys(price);
	    item_page.items_input_page_unit_dropdown.click();
	    utils.waitForElementToBeVisible(item_page.items_input_page_unit_pc_option);
	    item_page.items_input_page_unit_pc_option.click();
	    item_page.items_input_page_description.sendKeys(description);
	}
	@When("I click Save Item button")
	public void i_click_save_item_button() {
	    item_page.items_page_saveItems_btn.click();
	}
	@Then("The Item is added to the Item list table")
	public void the_item_is_added_to_the_item_list_table() {
		utils.waitForElementToBeVisible(item_page.items_page_item_headerText);
		Assert.assertTrue(item_page.items_page_item_headerText.isDisplayed()); 
		item_page.items_page_filter_btn.click();
		utils.waitForElementToBeVisible(item_page.items_page_filter_nameBox);
		item_page.items_page_filter_nameBox.sendKeys(itemName);
		utils.waitUntilElementVisibleWithLocator(By.xpath("//a[contains(text(), '" + itemName +"']"));
		Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[contains(text(), '" + itemName +"']")).isDisplayed());
		
	}
	@Then("I delete the item")
	public void i_delete_the_item() {
		utils.waitForElementToBeVisible(item_page.items_page_3dot_menue);
		item_page.items_page_3dot_menue.click();
		utils.waitForElementToBeVisible(item_page.items_page_3dot_delete_option);
		item_page.items_page_3dot_delete_option.click();
		utils.waitForElementToBeVisible(item_page.items_input_delete_yourSure_text);
		Assert.assertTrue(item_page.items_input_delete_yourSure_text.isDisplayed());
		item_page.items_input_delete_ok_btn.click();
		utils.waitForElementToBeVisible(item_page.items_input_NoResultsFound_text);
		Assert.assertTrue(item_page.items_input_NoResultsFound_text.isDisplayed());
	 
	}

// Update Items Scenario 
	@When("I click on Edit button")
	public void i_click_on_edit_button() {
	  //utils.waitUntilElementVisibleWithLocator(By.xpath("//button[contains(@id, 'headlessui-menu-button')])[3]"));
	  //item_page.items_page_3dot_menue.click();
	   //utils.waitForElementToBeVisible( item_page.items_page_3dot_edit_option);
	   //item_page.items_page_3dot_edit_option.click();
		utils.waitUntilElementVisibleWithLocator(By.xpath("//a[contains(text(), '" + itemName +"']"));
		Driver.getDriver().findElement(By.xpath("//a[contains(text(), '" + itemName +"']")).click();
	}
	@Then("I should be on Edit items page")
	public void i_should_be_on_edit_items_page() {
	   utils.waitForElementToBeVisible(item_page.items_page_Update_Item_btn);
	   Assert.assertTrue(item_page.items_page_Update_Item_btn.isDisplayed());
	}
	@When("I update the items price to {string}")
	public void i_update_the_items_price_to(String newPrice) {
	   item_page.items_input_page_price_box.clear();
	   item_page.items_input_page_price_box.sendKeys(newPrice);
	}
	@When("I click on update item button")
	public void i_click_on_update_item_button() {
	  item_page.items_page_Update_Item_btn.click();
	}
	@Then("Items price should be update to {string}")
	public void items_price_should_be_update_to(String newPrice) {
	utils.waitForElementToBeVisible(item_page.items_page_item_headerText);
	Assert.assertTrue(item_page.items_page_item_headerText.isDisplayed());
	item_page.items_page_filter_btn.click();
	utils.waitForElementToBeVisible(item_page.items_page_filter_nameBox);
	item_page.items_page_filter_nameBox.sendKeys(itemName);
	utils.waitUntilElementVisibleWithLocator(By.xpath("//a[contains(text(), '" + itemName +"']"));
	
	//get the price of the item and validate
	
	String trimmedPrice = newPrice.substring(0, 2);
	Driver.getDriver().findElement(By.xpath("//span[conatins(text(), '"+ trimmedPrice +"')]"));
	Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//span[conatins(text(), '"+ trimmedPrice +"')]")).isDisplayed());
	
	}





}
