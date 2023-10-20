package test;

import java.time.Duration;

import pages.AmazonHomepage;
import utils.Driver;
import utils.TestDataReader;

public class TestClass {

	public static void main(String[] args) {
		Driver.getDriver().get(TestDataReader.getProperty("amazonurl"));
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		AmazonHomepage azpage = new AmazonHomepage();
		azpage.amzaonSearchbox.sendKeys("Coffee mug");
		azpage.amazonSearchButton.click();

	}

}
