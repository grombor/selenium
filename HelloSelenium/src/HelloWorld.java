import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorld {

	public static void main(String[] args) {
		
//		Inernet Explorer web driver
//		System.setProperty("webdriver.ie.driver", "c:\\path\\to\\driver\\IEDriverServer.exe");
//		WebDriver driver = new InternerExplorerDriver();
		
//		Mozilla web driver setup
//		System.setProperty("webdriver.gecko.driver","G:\\path\\to\\driver\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
//		Safari web driver set up
//		WebDriver driver = new SafariDriver();
		
//		Optional, if not specified, WebDriver will search your path for chromedriver.
		System.setProperty("webdriver.chrome.driver", "/home/grombor/selenium-java-3.8.1/chromedriver");
		
//		Chrome web driver
		WebDriver webDriver = new ChromeDriver();
		
//		webDriver.get("http://kmarchel.pl");  // get web page in the browser
//		System.out.println("Size of skills field is: " + webDriver.findElement(By.id("skills")).getSize());
		
//		We try some test with GitHub
		webDriver.get("https://github.com/");
		
//		Print page title
		System.out.println("Page title: " + webDriver.getTitle());
		
//		Retrieve real page host URL
		System.out.println("Page current URL: " + webDriver.getCurrentUrl());
		
//		Find login field and put some text here
		webDriver.findElement(By.id("user[login]")).sendKeys("My_login");
		
//		Find email field and put some text here
		webDriver.findElement(By.id("user[email]")).sendKeys("password@my.com");
		
//		Find password field and put some text here
		webDriver.findElement(By.id("user[password]")).sendKeys("user[password]");
		
//		Print page source to console
//		System.out.println("Page source:");
//		System.out.println(webDriver.getPageSource());
		
//		Close web browser
//		webDriver.close();
		
		

	}

}