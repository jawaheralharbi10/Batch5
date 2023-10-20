package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class AmazonHomepage {

	public AmazonHomepage() {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	@FindBy(id = "twotabsearchtextbox")
	public WebElement amzaonSearchbox;
	
	@FindBy (xpath = "//input[@id='nav-search-submit-button']")
	public WebElement amazonSearchButton;
}
