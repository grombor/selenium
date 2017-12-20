import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreeShot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "/home/grombor/selenium-java-3.8.1/chromedriver");
		WebDriver google = new ChromeDriver();
		google.get("http://google.com");
		
//		Take sshot
		File src = ((TakesScreenshot) google).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/home/grombor/selenium-java-3.8.1/SShots/screen.png"));
		System.out.println("Screenshot made.");
		google.close();
	}

}
