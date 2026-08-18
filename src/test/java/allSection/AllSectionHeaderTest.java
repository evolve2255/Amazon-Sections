package allSection;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import allPageFactory.AllSectionWindow;
import testComponents.BaseTests;

public class AllSectionHeaderTest extends BaseTests {
	

	@Test
	public void verifyAllSectionHeaders() throws IOException {
		String[] expectedHeaders ={"Digital Content & Devices", "Shop by Department","Programs & Features","Help & Settings"};
//		driver = initializeBrowser();
//		driver.get("https://www.amazon.com/");
//		driver.manage().window().maximize();
//		WebElement allButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-hamburger-menu")));
//		allButton.click();
//		WebElement headerElement = wait.until(ExpectedConditions.
//				elementToBeClickable(By.xpath("//div[@data-menu-id='1']/section/div[@role='heading']")));
//		List<WebElement>headerElements = driver.findElements(By.xpath("//div[@data-menu-id='1']/section/div[@role='heading']"));
//		List<String> headerTextActual = headerElements.stream().map(s->s.getText()).toList().subList(0, 4);
////		List<String> headerTextActual = headerText.subList(0, 4);// can be added in the above step.
////		System.out.println( headerText.size());
//		System.out.println( headerTextActual.size());
//
//		for(String text :headerTextActual) {
//			System.out.println(text);
//		}
//		
		landingpage.clickAllButton();
		AllSectionWindow allSection = new AllSectionWindow(driver, wait);
		List<String> headerTextActual=allSection.getHeaderElements();
		List<String>expectedHeadersList = Arrays.asList(expectedHeaders);
		Assert.assertEquals(headerTextActual, expectedHeadersList);
	}
	
	@Test
	public void verifyNavButtonOfDigital() throws IOException {
//		driver = initializeBrowser();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		driver.get("https://www.amazon.com/");
//		driver.manage().window().maximize();
//		WebElement allButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-hamburger-menu")));
//		allButton.click();
//		
//		 wait.until(ExpectedConditions.elementToBeClickable(By
//				.xpath("//section[@class='category-section' and contains(@aria-labelledby,'Digital')]//a")));
//		 List<WebElement> digitalContentSection = driver.findElements(By.
//				 xpath("//section[@class='category-section' and contains(@aria-labelledby,'Digital')]//a")).subList(0, 4);
//		
//		System.out.println(digitalContentSection.size());
//		for(WebElement ele: digitalContentSection ) {
//			
//			System.out.println(ele.getAttribute("textContent"));
//		}
		AllSectionWindow window = landingpage.clickAllButton();
		List<WebElement> digitalContentSection =window.getDigitalContentElements();

		for(WebElement ele:digitalContentSection) {
			boolean hasArrow = ele.findElements(By.xpath(".//i[contains(@class,'hmenu-arrow-next')]")).size()>0;
			System.out.println(ele.getAttribute("textContent"));
				Assert.assertTrue(hasArrow,
			            "Arrow icon കണ്ടെത്തിയില്ല: " + ele.getAttribute("textContent").trim());
			
		}
		
	}
	
	@Test
	public void seeAllSeeLessSwitchTest() throws IOException {
		String element1 ="See all";
		String element2 ="See less";
//		driver = initializeBrowser();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		driver.get("https://www.amazon.com/");
//		driver.manage().window().maximize();
		
//		 wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-hamburger-menu"))).click();
		 
//		 WebElement seeAll = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-labelledby*='Department'] [aria-label='See all']")));
//		 
//		 WebElement seeLess = driver.findElement(By.cssSelector("[aria-labelledby*='Department'] [aria-label='See less']"));
		AllSectionWindow window =landingpage.clickAllButton();
		List<WebElement> seeElemets =window.getSeeElements();
		WebElement seeAll = seeElemets.get(0);
		WebElement seeLess = seeElemets.get(1);
		String seeAllText = seeAll.getAttribute("textContent");
		seeAll.click();
		 
		 if(seeAll.isDisplayed()) {
		 		Assert.assertFalse(seeLess.isDisplayed());
		 	}else if(seeLess.isDisplayed()) {
		 		Assert.assertFalse(seeAll.isDisplayed());
		 		
		 	}
		 
	 	 String seeLessText = seeLess.getText();
	 	 System.out.println(seeAllText);
	 	 System.out.println(seeLessText);
	 	
	 	 Assert.assertEquals(seeAllText, element1);
	 	 Assert.assertEquals(seeLessText, element2);
	 	 
	 	}
	@Test(retryAnalyzer = Retry.class)
	public void checkDimensionOfAllSection() throws IOException {
		
		int heght = 900;
		int width = 365;
//		driver = initializeBrowser();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		driver.get("https://www.amazon.com/");
//		driver.manage().window().maximize();
//		
//		 wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-hamburger-menu"))).click();
		 
//		 WebElement allBox =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#hmenu-canvas")));
//		 int heghtActual = allBox.getSize().getHeight();
//		 int widthActual = allBox.getSize().getWidth();
		
		 AllSectionWindow window = landingpage.clickAllButton();
		 List<Integer> dimension =window.getDimensions();
		 int heghtActual = dimension.get(0);
		 int widthActual = dimension.get(1);
		 System.out.println("Dimension: "+heghtActual+" X "+widthActual);
		 
		 Assert.assertEquals(heghtActual, heght);
		 Assert.assertEquals(widthActual, width);
	}

}
