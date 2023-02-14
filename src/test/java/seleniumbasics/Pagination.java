package seleniumbasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {
	static  WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException
	{
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 
	 driver.get("https://classic.freecrm.com/index.html");
	 driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Test@123");
	 driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("test@123");
	 driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	 
	 Thread.sleep(2000);
	 
	 driver.switchTo().frame("mainpanel");
	 driver.findElement(By.xpath("//a[@title=\"Contacts\"]")).click();
	 Thread.sleep(2000);
	 
	 List<WebElement>pages =driver.findElements(By.xpath("(//div[@class='pagination'])[1]/a")); 
	 int i=0;
	 while(true)
	 {
		 if(driver.findElements(By.linkText("test4 test4")).size()==1)
		 {
			 selectContact("test4 test4");
			 break;
		 }
		 else
		 {
			try {
				pages.get(i).click();
			} catch (Exception e)
			{
				System.out.println("Contact not found in pagination");
				break;
			} 
			 pages =driver.findElements(By.xpath("(//div[@class='pagination'])[1]/a"));
		 }
		 i++;
	 }
	
	}
	
	public static void selectContact(String name) {
		String checkBoxXpath = "//a[text()='" + name
				+ "']/parent::td/preceding-sibling::td/child::input[@type='checkbox' and @name='contact_id']";
		driver.findElement(By.xpath(checkBoxXpath)).click();
	
}
}