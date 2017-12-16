import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragable {
	public static void main (String []args) {
		
//		Initialize setup settings
		System.setProperty("webdriver.chrome.driver", "/home/grombor/selenium-java-3.8.1/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
		
//		Show how to switch to iframe element
		WebElement frame =  driver.findElement(By.cssSelector("iframe.demo-frame"));
		driver.switchTo().frame(frame);
		
//		Setup a new Actions object
		Actions actions = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		actions.dragAndDrop(source, target).build().perform();
		
//		Go to default content
		driver.switchTo().defaultContent();
		String keysCombo = Keys.chord(Keys.CONTROL,Keys.ENTER);
		
//		Open link in a new tab
		driver.findElement(By.linkText("Sortable")).sendKeys(keysCombo);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
//		Go to new tab and click sth
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.linkText("Connect lists")).click();
		target = driver.findElement(By.linkText("jQuery Foundation"));
		actions.moveToElement(target).build().perform();
		
//		Go back to current tab and close it
		driver.switchTo().window(tabs.get(0));
		driver.close();
	}
}
