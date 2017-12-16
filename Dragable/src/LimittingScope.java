import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimittingScope {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/grombor/selenium-java-3.8.1/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://kmarchel.pl");
		
//		Print total number of linnks on a page
		System.out.println("Total number of links on a site:");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
//		Print total number of links in a certain section (ex. skills section)
		WebElement skills = driver.findElement(By.id("skills"));
		int elementsSize = skills.findElements(By.tagName("li")).size();
		System.out.println("Total number of elements:");
		System.out.println(elementsSize);
		for (int i=0; i<elementsSize; i++) {
			System.out.println(skills.findElements(By.tagName("li")).get(i).getText());
		}
		
		driver.close();
	}

}
