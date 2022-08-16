package technicalChallenge;


import java.time.Duration;
import java.util.Properties;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.*;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestCase1 {
	
	Properties r = new Properties();
	Functions f = new Functions();
	WebDriver driver;
	

	@BeforeTest
	public void launchBrowser() throws IOException {
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\Repo.properties");
		r.load(objfile);
		
		System.setProperty("webdriver.chrome.driver", r.getProperty("driverPath"));
		driver = new ChromeDriver();
		driver.get(r.getProperty("baseUrl")); // open airbnb URL
		driver.manage().window().maximize(); // maximize website window		
		
	}

	@Test
	public void main() throws IOException {
		
		
		f.clickElement(driver, r.getProperty("firstWhere"));
		
		WebElement secondElement = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(r.getProperty("secondWhere")))); //find second search bar
		secondElement.sendKeys("xgeeks"); // Write in search bar
		
		f.getScreenshot(driver, "C:\\xgeeks_workspace\\Images_Test_Case_1", "1"); //First Screenshot
		
		String result = secondElement.getAttribute("value");
		System.out.println("Resultado Fase 1:" + result);

		f.clickElement(driver, r.getProperty("deleteButton"));
		
		f.getScreenshot(driver, "C:\\xgeeks_workspace\\Images_Test_Case_1", "2"); // Second Screenshot

		result = secondElement.getAttribute("value");
		
		if (result != "") {
			System.out.println("Resultado Final: Falhou!");
		} else {
			System.out.println("Resultado Final: Passou!");
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
