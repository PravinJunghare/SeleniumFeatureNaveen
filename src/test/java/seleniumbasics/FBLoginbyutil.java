package seleniumbasics;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FBLoginbyutil {

	public static void main(String[] args) {
		//BasicConfigurator.configure();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	    By emailid =By.id("email_container");
	    By password=By.id("pass");
	    By loginbtn=By.name("login");
	   
	    ElementUtil elementutil=new ElementUtil(driver);
	    elementutil.waitforelementTobepresent(loginbtn, 15).sendKeys("testing");
	   
	    elementutil.dosendKey(password,"test@23");
	   
	    elementutil.doClick(loginbtn);
	    
	    String title=  elementutil.waitforTitletobebepresent("facebook", 15);
	    System.out.println(title);
	   
	    System.out.println("----------------");
	}

}
