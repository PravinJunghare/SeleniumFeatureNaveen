package seleniumbasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RandomClickMonkeyTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		driver.get("https://www.amazon.in/");
	    List<WebElement>list= driver.findElements(By.xpath("//div[@id=\"nav-al-wishlist\"]/a"));
	    int totalcount=list.size();
	    for(int i=0;i<totalcount;i++)
	    {
	    	int randomindex= (int)Math.floor(Math.random()*totalcount);
	    	System.out.println(randomindex);
	    	 WebElement e= list.get(randomindex);
	    	 System.out.println(e.getText());
	    	e.click(); 
	    	driver.navigate().back();
	    	 list= driver.findElements(By.xpath("//div[@id=\"nav-al-wishlist\"]/a"));
	    	
	    }
	 
	    
	}
	
	
	

}
