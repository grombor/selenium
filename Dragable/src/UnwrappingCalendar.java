import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UnwrappingCalendar {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/grombor/selenium-java-3.8.1/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.loveholidays.com/");
		
//		TODO - erase popup issue at the bottom
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
//		Get the calendar xpath
		driver.findElement(By.xpath("//div[@class='link-input']/a[@class='link-input__input link-input__input--is-placeholder']")).click();
		
//		Get Select web element and select option for June
		Select select = new Select (driver.findElement(By.cssSelector("div.search-unit-custom-control-calendar__month > select")));
		select.selectByVisibleText("June 2018");
		
//		Put all calendar cells into a list container
		List<WebElement> target = driver.findElements(By.cssSelector("td.search-unit-custom-control-calendar-day.search-unit-custom-control-calendar-day--available"));
		
//		Scroll down page
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
//		Iterate through all list element until find our day
		for (int i=0; i<target.size(); i++) {
			String getCelltext = target.get(i).getText();
			if (getCelltext.equals("14")) {
				System.out.println("Found!" + target.get(i).getText());
				target.get(i).click();
			}
		}
		
	}

}
