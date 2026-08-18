package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import allPageFactory.LandingPage;

public class BaseTests {
	public WebDriver driver;
	public WebDriverWait wait ;
	public LandingPage landingpage;
	
	public WebDriver initializeBrowser() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\browser.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
		}
		if(browserName.equalsIgnoreCase("firefox")) {
			
			driver= new FirefoxDriver();
		}
		if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
					
		}
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver;
	}
	
	
	public String getScreenshot(String testCaseName, WebDriver driver ) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =  ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(System.getProperty("user.dir")+"\\reports\\screenshots\\"+testCaseName+".png");
		FileUtils.copyFile(source, destinationFile);
		return "screenshots\\"+testCaseName+".png";
	}
	
	@BeforeMethod
	public  void launchApplication() throws IOException {
		
		driver =initializeBrowser();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		landingpage = new LandingPage(driver, wait);
//		return landingpage;
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.quit();
	}

}
