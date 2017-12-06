import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorld {

	public static void main(String[] args) {
		// Optional, if not specified, WebDriver will search your path for chromedriver.
		  System.setProperty("webdriver.chrome.driver", "/home/grombor/selenium-java-3.8.1/chromedriver");
		
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("http://kmarchel.pl");
		
//		Print page title
		System.out.println("Page title" + webDriver.getTitle());
		
//		Retrieve real page host URL
		System.out.println("Page current URL" + webDriver.getCurrentUrl());
		
//		Print page source to console
		System.out.println("Page source:");
		System.out.println(webDriver.getPageSource());
		
//		Close web browser
		webDriver.close();

	}

}