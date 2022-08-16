package technicalChallenge;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

	String driverPath = "C:\\xgeeks_workspace\\ChromeDriver\\chromedriver.exe";
	String baseUrl = "https://www.airbnb.com/";
	WebDriver driver;
	Properties r = new Properties();
	Functions f = new Functions();

	@BeforeTest
	public void launchBrowser() throws IOException{
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\Repo.properties");
		r.load(objfile);
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl); // open airbnb URL
		driver.manage().window().maximize(); // maximize website window
	}

	@Test
	public void main() throws IOException, InterruptedException {
		
		TimeUnit.SECONDS.sleep(1);
		f.clickElement(driver, r.getProperty("date"));
		
		f.clickElement(driver, r.getProperty("nextButton"));
		TimeUnit.SECONDS.sleep(1);
		
		f.clickElement(driver, r.getProperty("octoberDay"));
		
		f.getScreenshot(driver, "C:\\xgeeks_workspace\\Images_Test_Case_2", "1");
		TimeUnit.SECONDS.sleep(1);
		
		f.clickElement(driver, r.getProperty("octoberDay2"));
		
		String text = f.getText(driver, r.getProperty("checkout"));
		f.getScreenshot(driver, "C:\\xgeeks_workspace\\Images_Test_Case_2", "2");
		
		if(text == ""){
			System.out.println("Resultado Final: Falhou!");
		}
		else {
			System.out.println("Resultado Final: Passou!");
		}		
		
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
