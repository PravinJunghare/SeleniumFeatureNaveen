package seleniumbasics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtil


{
	/*this method is to select value from dropdown
	 * parameter element
	 * parameter value
	 */
	public static void selectDropdownValueByText(WebElement element, String value)
	{
		Select select =new Select(element);
		select.selectByVisibleText(value);
		
	}
	
	public static void selectDropdownValueByIndex(WebElement element, int index)
	{
		Select select =new Select(element);
		select.selectByIndex(index);
		
	}
	
	/*this method is to get values from dropdown
	 * parameter element
	 * 
	 */
	public static ArrayList<String> getDropdownValues(WebElement elemet)
	{
		Select select =new Select(elemet);
		System.out.println("===========================");
		List<WebElement>droplist= select.getOptions();
	    System.out.println("Total no values in dropdown "+ droplist.size());
		  ArrayList<String> ar =new ArrayList<String>();
		for(int i=0;i<droplist.size();i++)
				  
		  {
			 String text= droplist.get(i).getText();
			 //System.out.println(text);
			 ar.add(text);
		  }
		return ar;
	}
}
