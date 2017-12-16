import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UnwrappingCalendar {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/grombor/selenium-java-3.8.1/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.loveholidays.com/");
		driver.findElement(By.xpath("//*[@class='cal-icon']")).click();
		
		Select select = new Select (driver.findElement(By.xpath("//div[@class='search-unit-custom-control-calendar__month']/select")));
		select.selectByVisibleText("June 2018");
		
	}

}
