package seleniumbasics;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CharSeqInTextField
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		WebElement email= driver.findElement(By.name("email"));
		
		// this is used to send char seq
	    StringBuffer un=new StringBuffer()
	    		.append("pravin")
	    		.append(" ").append("Junghare");
	    email.sendKeys(un,Keys.TAB);// Here Key tab is used for press tab
	    
	
	
	}

}
