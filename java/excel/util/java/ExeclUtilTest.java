package excel.util.java;

public class ExeclUtilTest {

	public static void main(String[] args)
	{
		Xls_Reader reader=new Xls_Reader("./java/excel/util/java/Sample.xlsx");
		String sheetName="Sheet1";
		
		// To get data from cell
		String data =reader.getCellData(sheetName,0, 2);
		System.out.println(data);
		System.out.println(reader.getCellData(sheetName, "username", 3));
		
		//Total no of row
		int rowCount= reader.getRowCount(sheetName);
		System.out.println("total number of rows :" +rowCount);
		
		// To add new column
		//reader.addColumn(sheetName, "status"); 
		
		// Remove Column
		
		//reader.removeColumn("Registration", 0);
		
		// To add sheeet
		//reader.addSheet("registration");
		if( !reader.isSheetExist("registration"))
			
			reader.addSheet("registration");
		
		// Write data to cell
		reader.setCellData(sheetName, "status", 2, "pass");
		
		//get data
		System.out.println(reader.getCellData("registration", "Phone no", 2));
		System.out.println(reader.getCellData("registration", "Age", 2));
		
		
   
	}

}
