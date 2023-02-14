package seleniumbasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","./TestNavProject/drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		driver.get("https://www.facebook.com/");
		
		// page objects
		By emailid =By.id("email");
        By password=By.id("pass");
        By loginButton= By.name("login");
        
        ElementUtil util=new ElementUtil(driver);
        util.dosendKey(emailid, "test@123.com");
        util.dosendKey(password, "test123");
        util.doClick(loginButton); 
	}

}
