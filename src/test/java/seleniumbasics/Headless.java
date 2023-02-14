package seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Headless {

	public static void main(String[] args)
	{
		// headless : no UI
		// testing is happen behind the scene
		// faster than normal UI mode
		
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions co =new ChromeOptions();
		co.addArguments("--headless");
		WebDriver driver=new ChromeDriver(co);
		
		driver.get("http://www.google.com");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		

	}

}
