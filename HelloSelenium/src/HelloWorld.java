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
		webDriver.findElement(By.xpath("//*[@id=\'user[login]\']")).sendKeys("test");
		
//		Find email field and put some text here
		webDriver.findElement(By.id("user[email]")).sendKeys("password@my.com");
		
//		Find password field by name and put some text here
		webDriver.findElement(By.name("user[password]")).sendKeys("user[password]");
		
//		Find submit button and click it
//		webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/form/button"));
		// this xpath is reliable
		
//		Find an element by linkText and click it
		webDriver.findElement(By.linkText("terms of service")); // can use .click(); or sth
		
//		Find an element by css selector
		webDriver.findElement(By.cssSelector("a.text-white.jumbotron-link")); // .click();
		
//		Find a error msg from webpage and print it to the console
		System.out.println(webDriver.findElement(By.cssSelector("p.form-control-note")).getText());
		
//		Find an element by own xpath
//		$x("//*[@type='submit']")
		webDriver.findElement(By.xpath("//input[@data-hotkey='s']")).sendKeys("trolo");
		
//		Find an element by own css selector $$("input[name='q']")
		webDriver.findElement(By.cssSelector("input[name='q']")).sendKeys("lolo");;
		
//		Print page source to console
//		System.out.println("Page source:");
//		System.out.println(webDriver.getPageSource());
		
//		Close web browser
//		webDriver.close();
		
		

	}

}