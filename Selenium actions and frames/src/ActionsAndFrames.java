import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsAndFrames {

	public static void main(String[] args) {
		
//		Initialize web driver
		System.setProperty("webdriver.chrome.driver", "/home/grombor/selenium-java-3.8.1/chromedriver");
		WebDriver driver = new ChromeDriver();
		
//		Initialize implicitly wait		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//		Initialize web page
		driver.get("https://www.amazon.co.uk/");
		
//		Initialize Actions
		Actions actions = new Actions(driver);
		
//		Initialize variables
		String path = "twotabsearchtextbox";
		WebElement target = driver.findElement(By.id(path));
		
//		Find searchbox and type some keys
		actions.moveToElement(target).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
	}

}
