package technicalChallenge;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Functions {
	
	public void getScreenshot(WebDriver driver, String path, String number) throws IOException {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(""+path +"\\image"+number+"-"+ new SimpleDateFormat("ddMMyyyy").format(new java.util.Date())+".png")); //First Screenshot

	}
	
	public void clickElement(WebDriver driver, String element) {
		
	 new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath(element))).click(); 

	}
	
	public String getText(WebDriver driver, String element) {
		
		return driver.findElement(By.xpath(element)).getText();
	}

}
