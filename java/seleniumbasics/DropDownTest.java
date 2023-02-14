package seleniumbasics;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownTest {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
	    WebElement day=	driver.findElement(By.id("day"));
	    WebElement month=driver.findElement(By.id("month"));
	    WebElement year=driver.findElement(By.id("year"));
	    /*Select the value/
	     * 
	     */
	    String date ="28-Dec-1991";
	    String datevalue[]=date.split("-");
	    DropDownUtil.selectDropdownValueByText(day, datevalue[0]);
	    DropDownUtil.selectDropdownValueByText(month, datevalue[1]);
	    DropDownUtil.selectDropdownValueByText(year, datevalue[2]);
	    
	    
	    /* total count
	     * 
	     */
	    ArrayList<String>daylist= DropDownUtil.getDropdownValues(day);
	    System.out.println(daylist);
	    ArrayList<String>monthlist= DropDownUtil.getDropdownValues(month);
	    System.out.println(monthlist);
	    ArrayList<String>yearlist= DropDownUtil.getDropdownValues(year);
	    System.out.println(yearlist);
	    
	    driver.quit();
	}
	

	}
	

