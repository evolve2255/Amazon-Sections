package allSection;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import allPageFactory.TodaysDealPage;
import testComponents.BaseTests;

public class TodaysDeals extends BaseTests{

	
	@Test
	public void verifyPresenceOfItemBox() throws IOException {
		
//		driver = initializeBrowser();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		driver.get("https://www.amazon.com");
//		driver.manage().window().maximize();
//		try {
//		wait.until(ExpectedConditions.
//				visibilityOfElementLocated(By.cssSelector("[data-action-type='DISMISS']"))).click();
//		}catch(Exception e) {
//			System.out.println("Location dialogue didn't found");
//		}
//		wait.until(ExpectedConditions.
//				elementToBeClickable(By.xpath("//a[text()=\"Today's Deals\"]"))).click();
//		WebElement filterBox = wait.until(ExpectedConditions.
//				presenceOfElementLocated(By.cssSelector("[data-tabulation-id=\"desktop-refinements\"]")));
		
		TodaysDealPage deals  = landingpage.clickTodaysDeal();
		boolean match = deals.verifyPresenceOfFilters();
		
		
//		System.out.println(itemBoxes.size());
		Assert.assertTrue(match);
		
		
	}
}
