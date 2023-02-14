package seleniumbasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload
{
	
	public static void main(String[] args){
		
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
	driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
	driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\admin\\Desktop");

	
	
}
}