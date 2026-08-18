package allPageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import allSection.AbstractComponents;

public class LandingPage extends AbstractComponents{
	WebDriver driver;
	WebDriverWait wait;
	
	public LandingPage(WebDriver driver, WebDriverWait wait) {
		
		this.driver=driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "nav-hamburger-menu")
	WebElement allButton;
	@FindBy(css = "#hmenu-canvas")
	WebElement AllItemBox;
	@FindBy(css = "[data-action-type='DISMISS']")
	WebElement locationDismissButton;
	@FindBy(xpath = "//a[text()=\"Today's Deals\"]")
	WebElement todaysDealButton;
	
	
//	public LandingPage launchApplication() {
//		
//		driver.get("https://www.amazon.com/");
//		LandingPage landingpage = new LandingPage(driver, wait);
//		return landingpage;
//	}

	public AllSectionWindow clickAllButton() {
		waitForElementToBeClickable(driver, wait, allButton);
		allButton.click();
		AllSectionWindow window = new AllSectionWindow(driver, wait);
		return window;
	}
	
	public TodaysDealPage clickTodaysDeal() {
		
		try {
			waitForElementToBeClickable(driver, wait, locationDismissButton);
			locationDismissButton.click();
			
			}catch(Exception e) {
				System.out.println("Location dialogue didn't found");
			}
			waitForElementToBeClickable(driver, wait, todaysDealButton);
			todaysDealButton.click();
			
			TodaysDealPage deals = new TodaysDealPage(driver, wait);
			return deals;
			
	}
}
