package seleniumbasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandel {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		driver.get("http://londonfreelance.org/courses/frames/index.html");
		
		//WebElement framelement= driver.findElement(By.name("main"));
		//driver.switchTo().frame(framelement);
		//driver.switchTo().frame("main");
		driver.switchTo().frame(2);
		String text= driver.findElement(By.cssSelector("body > h2")).getText();
		System.out.println(text);
		driver.switchTo().defaultContent();// Retuen to main page
		driver.switchTo().parentFrame();//Retuen to main page
		 

	}

}
