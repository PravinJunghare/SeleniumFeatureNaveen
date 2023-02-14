package seleniumbasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalTextFields {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		List<WebElement> listinput=  driver.findElements(By.tagName("input"));
		System.out.println(listinput.size());
		
		List<WebElement>inputfields=driver.findElements(By.xpath("//input[@type='text']"));
		
		System.out.println(inputfields.size());
		
		for (int i=0;i<inputfields.size();i++)
		{
			inputfields.get(i).sendKeys("pravin");
		}
	}

}
