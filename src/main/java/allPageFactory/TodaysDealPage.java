package allPageFactory;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import allSection.AbstractComponents;

public class TodaysDealPage extends AbstractComponents{
	
	WebDriver driver;
	WebDriverWait wait;
	
	public TodaysDealPage(WebDriver driver, WebDriverWait wait) {
		
		this.driver=driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[data-tabulation-id=\"desktop-refinements\"]")
	WebElement filterBox;
	
	
	public boolean verifyPresenceOfFilters() {
		
		try {
			waitForElementToBeVisible(driver, wait, filterBox);
			return filterBox.isDisplayed();
		}catch( NoSuchElementException e){
			return false;
		}
		
	}

}
