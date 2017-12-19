import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablesAndSSL {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/home/grombor/selenium-java-3.8.1/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.cricbuzz.com/live-cricket-scorecard/17690/a-vs-eng-3rd-test-the-ashes-2017-18");
		
//		 find current table
		WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		
//		 get rows qty
		int rowsQty = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'")).size();
		
		List<WebElement> column = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)"));
		int counter = column.size();
		
		Integer total = 0;
		
		for (int i=0; i<counter-2; i++){
			System.out.print(column.get(i).getText() + " + ");
			total+=Integer.parseInt(column.get(i).getText());
		}
		String s = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
		System.out.println(s);
		total+=Integer.parseInt(s);
		System.out.println("TOTAL: " + total);
		s = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
		driver.close();
		if (total.toString().equals(s)) {
			System.out.println("Is correct!");
		}
		else {
			System.out.println("Don't fit :(");
		}
	}

}
