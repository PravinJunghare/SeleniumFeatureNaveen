package seleniumbasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination1 {
	static WebDriver driver;
// logic for select checkbox
	public static void selectContact(String name) {
		String checkBoxXpath = "//a[text()='" + name
				+ "']/parent::td/preceding-sibling::td/child::input[@type='checkbox' and @name='contact_id']";
		driver.findElement(By.xpath(checkBoxXpath)).click();
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/");
		driver.findElement(By.name("username")).sendKeys("Test@123");
		driver.findElement(By.name("password")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Thread.sleep(3000);
       // there is frame so first need to move to frame
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		Thread.sleep(3000);
       // number of pages are there and each has a link so we find xpath for each link and used findelemnets method
		List<WebElement> pages = driver.findElements(By.xpath("(//div[@class='pagination'])[1]/a"));
     // as we dont no exact postion of element to search so we used while loop 
		int i = 0;
		while (true) {
			// here used elemenets because we have to go to all links if found then size will be 1
			if (driver.findElements(By.linkText("test4 test4")).size() == 1) {
				selectContact("test4 test4");// for selection called method
				break;
			}
			// if not found need to click on next
			else {
				try {
					pages.get(i).click();// will give the count
				} catch (Exception e) {
					System.out.println("pagination is over.....and dint find any contact");
					break;
				}
				pages = driver.findElements(By.xpath("(//div[@class='pagination'])[1]/a"));
				// here after clicking new list will be updated
			}
			i++; // for increasing the page 
		}

	}

}