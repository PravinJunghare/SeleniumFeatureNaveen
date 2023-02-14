package excel.util.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Logintest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		// Webelement
		WebElement userName= driver.findElement(By.name("username"));
		WebElement pwd= driver.findElement(By.name("password"));
		
		// Data fecthing logic 
		Xls_Reader reader=new Xls_Reader("./java/excel/util/java/Sample.xlsx");
		String sheetName="Sheet1";
		int rowcount=reader.getRowCount(sheetName);
		
		// from second row so loop start from 2
		for (int rowNum=2;rowNum<=rowcount;rowNum++)
		{
			String loginId=reader.getCellData(sheetName, "username", rowNum);
			String password=reader.getCellData(sheetName, "password", rowNum);
			System.out.println(loginId+""+password);
			
			userName.clear();
			userName.sendKeys(loginId);
			pwd.clear();
			pwd.sendKeys(password);
		}
		
		

	}

}
