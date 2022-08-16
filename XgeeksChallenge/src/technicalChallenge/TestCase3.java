package technicalChallenge;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestCase3 {

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
	public void main()  throws IOException, InterruptedException {
		Boolean value = false;
		
		TimeUnit.SECONDS.sleep(1);
		f.clickElement(driver, r.getProperty("addGuests"));
		
		TimeUnit.SECONDS.sleep(1);
		f.clickElement(driver, r.getProperty("addChildren"));
		
		f.getScreenshot(driver, "C:\\xgeeks_workspace\\Images_Test_Case_3", "1");
		
		TimeUnit.SECONDS.sleep(1);
		value = driver.findElement(By.xpath(r.getProperty("removeAdults"))).isEnabled();
		

		if (value == true) {
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
