package seleniumbasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickOperation {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
        WebElement rightClickElement= driver.findElement(By.xpath("//span[text( )='right click me']"));
        Actions action =new Actions(driver);
        action.contextClick(rightClickElement).build().perform();
        
       String text= driver.findElement(By.xpath("//ul/li[contains(@class,' context-menu-icon-copy')]")).getText();
       System.out.println(text);
	}

}
