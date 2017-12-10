import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HelloSelenium {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/grombor/selenium-java-3.8.1/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.onthebeach.co.uk/");
		
		String selectField = "select#search_destination_id";
		
		Select select = new Select(driver.findElement(By.cssSelector(selectField)));
		select.selectByValue("126");
		
		selectField = "//*[@id='search_departing_from']";
		select = new Select(driver.findElement(By.xpath(selectField)));
		select.selectByValue("MAN");
		
		String selectFor = "//button[@data-trigger='nights']";
		driver.findElement(By.xpath(selectFor)).click();
		
		String selectNigths = "//label[@for='search_nights_4']" ;
		driver.findElement(By.xpath(selectNigths)).click();;
		
	}

}
