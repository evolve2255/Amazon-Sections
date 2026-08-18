package allPageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

import allSection.AbstractComponents;

public class AllSectionWindow extends AbstractComponents{

	WebDriver driver;
	WebDriverWait wait;
public AllSectionWindow(WebDriver driver, WebDriverWait wait) {
		
		this.driver=driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@data-menu-id='1']/section/div[@role='heading']")
	List<WebElement> headerElements;
	@FindBy(xpath = "//div[@data-menu-id='1']/section/div[@role='heading']")
	WebElement headerElement;
    @FindBy(xpath = "//section[@class='category-section' and contains(@aria-labelledby,'Digital')]//a")
    List<WebElement> digitalContentSection;
    @FindBy(xpath = "//section[@class='category-section' and contains(@aria-labelledby,'Digital')]//a")
    WebElement digitalContent;
    @FindBy(xpath = ".//i[contains(@class,'hmenu-arrow-next')]")
	WebElement arrowButton;
    @FindBy(css = "[aria-labelledby*='Department'] [aria-label='See all']")
    WebElement seeAllLabel;
    @FindBy(css = "[aria-labelledby*='Department'] [aria-label='See less']")
    WebElement seeLessLabel;
    @FindBy(css = "#hmenu-canvas")
    WebElement allMenuBox;
    
    public List<String> getHeaderElements() {
    	
    	waitForElementToBeClickable(driver, wait, headerElement);
    	List<String> headerTextActual = headerElements.stream().map(s->s.getText()).toList().subList(0, 4);
    	
    	System.out.println( headerTextActual.size());

		for(String text :headerTextActual) {
			System.out.println(text);
		}
		
		
		return headerTextActual;
	}
    

    
    public List<WebElement> getDigitalContentElements() {
    	
    	waitForElementToBeClickable(driver, wait, digitalContent);
    	return digitalContentSection.subList(0, 4);
    }
    
    public List<WebElement> getSeeElements() {
    	waitForElementToBeClickable(driver, wait, seeAllLabel);
    	List<WebElement> seeElements = List.of(seeAllLabel, seeLessLabel);
    	
    	return seeElements;
    	
    }
    
    public List<Integer> getDimensions() {
//    	int[] dimension = new int[2];
    	waitForElementToBeVisible(driver, wait, allMenuBox);
    	int height = allMenuBox.getRect().getDimension().getHeight();
    	int weight = allMenuBox.getRect().getDimension().getWidth();
    	List<Integer> dimensionList = new ArrayList<>();
    	dimensionList.add(height);
    	dimensionList.add(weight);
    	return dimensionList;
    			
    
    }
}

