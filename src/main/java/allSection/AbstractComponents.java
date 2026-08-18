package allSection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

	public void waitForElementToBeClickable(WebDriver driver,WebDriverWait wait, WebElement element) {
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementToBeVisible(WebDriver driver,WebDriverWait wait, WebElement element) {
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
}
