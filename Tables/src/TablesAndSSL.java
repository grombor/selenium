import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TablesAndSSL {

	public static void main(String[] args) throws IOException {

		new DesiredCapabilities();

//				SSL handling
		DesiredCapabilities dc = DesiredCapabilities.chrome();
//		one way to set it up
//		dc.acceptInsecureCerts();
		
//		Second way to set it up
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.merge(dc);
		
//		Webdriver initiazlization
		System.setProperty("webdriver.chrome.driver", "/home/grombor/selenium-java-3.8.1/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.cricbuzz.com/live-cricket-scorecard/17690/a-vs-eng-3rd-test-the-ashes-2017-18");
		
//		Set up implicitly wait to 5 secs
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//		Find current table
		WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		
//		Put all collumns from all rows into a list
		List<WebElement> column = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)"));
		int counter = column.size();
		
		Integer total = 0;

//		get the score from each colummn, sum of columns
		for (int i=0; i<counter-2; i++){
			System.out.print(column.get(i).getText() + " + ");
			total+=Integer.parseInt(column.get(i).getText());
		}
		
//		Get the Extra points from Extra column
		String s = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
		System.out.println(s);
		total+=Integer.parseInt(s);
		System.out.println("TOTAL: " + total);
		
//		Find Total on the web page
		s = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
		driver.close();
		
//		Check is sum the same like total on webpage
		if (total.toString().equals(s)) {
			System.out.println("Is correct!");
		}
		else {
			System.out.println("Don't fit :(");
		}
		
	}

}
