import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelloSelenium {

	public static void main(String[] args) {
//		Initialize variables
		System.setProperty("webdriver.chrome.driver", "/home/grombor/selenium-java-3.8.1/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
//		Choose web page to test
		driver.get("https://www.onthebeach.co.uk/");
		
//		Pick the destination
		String path = "select#search_destination_id";
		
		Select select = new Select(driver.findElement(By.cssSelector(path)));
		select.selectByValue("126");
		
//		Pick departure airport
		path = "//*[@id='search_departing_from']";
		select = new Select(driver.findElement(By.xpath(path)));
		select.selectByValue("MAN");
		
//		Pick one of the nights option
		path = "//button[@data-trigger='nights']";
		driver.findElement(By.xpath(path)).click();
		
		path = "//label[@for='search_nights_4']" ;
		driver.findElement(By.xpath(path)).click();
		
//		Pick a date from a calendar
		path = "//button[@data-trigger='departure_date']";
//		Explicit wait
		WebDriverWait dWait = new WebDriverWait(driver, 5);
		driver.findElement(By.xpath(path)).click();
		path = "//table/tbody/tr[3]/td[5]";
		d.until(ExpectedConditions.elementToBeClickable(path));
		driver.findElement(By.xpath(path)).click();
		
//		Pick party size
		path = "//button/span[2]";
		driver.findElement(By.xpath(path)).click();
		
//		Check a checkbox
		path = "//*[@class='option__selection option__selection--small']";
		if (!driver.findElement(By.xpath(path)).isSelected()) {
			driver.findElement(By.xpath(path)).click();
		}
		
	}

}
