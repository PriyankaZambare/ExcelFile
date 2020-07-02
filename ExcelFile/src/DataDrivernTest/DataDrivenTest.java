package DataDrivernTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTest {


public static void main(String[] args) throws IOException {
	
System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe")	;
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("http://newtours.demoaut.com/");


FileInputStream file =new FileInputStream("C:/Users/Priya/Desktop/ExcelSheets/datadrivernTest.xlsx");	
XSSFWorkbook workbook =new XSSFWorkbook(file);		
XSSFSheet sheet =workbook.getSheet("Sheet1");
 int TotalRows =sheet.getLastRowNum();
 
  for(int i=1;i<TotalRows;i++) {
	XSSFRow currnetRow = sheet.getRow(i);
 //   sheet.getRow(i).getCell(i).getCellType(CellType.String);
	currnetRow.getCell(0).setCellType(CellType.STRING);
	String First_Name = currnetRow.getCell(0).getStringCellValue();
	String Last_Name =currnetRow.getCell(1).getStringCellValue();//
    
	String Phone =currnetRow.getCell(2).getStringCellValue();
	String Email =currnetRow.getCell(3).getStringCellValue();
	String Address =currnetRow.getCell(4).getStringCellValue();
	String City=currnetRow.getCell(5).getStringCellValue();
	String State=currnetRow.getCell(6).getStringCellValue();
	String Postal_Code =currnetRow.getCell(7).getStringCellValue();
	String Country =currnetRow.getCell(8).getStringCellValue();
	String User_Name=currnetRow.getCell(9).getStringCellValue();
	String Password=currnetRow.getCell(10).getStringCellValue();
	
//	XSSFCell Frist_Name = row.getCell(0);
	//int name=(int)Frist_Name.getNumericCellValue();/
	
	driver.findElement(By.linkText("REGISTER")).click();

	
	driver.findElement(By.name("firstName")).sendKeys(First_Name);
	driver.findElement(By.name("lastName")).sendKeys(Last_Name);
	driver.findElement(By.name("phone")).sendKeys(Phone);
	driver.findElement(By.name("userName")).sendKeys(Email);
	driver.findElement(By.name("address1")).sendKeys(Address);
	driver.findElement(By.name("city")).sendKeys(City);
	driver.findElement(By.name("state")).sendKeys(State);
	driver.findElement(By.name("postalCode")).sendKeys(Postal_Code);
	driver.findElement(By.name("country")).sendKeys(Country);
	driver.findElement(By.name("email")).sendKeys(User_Name);
	driver.findElement(By.name("password")).sendKeys(Password);
	driver.findElement(By.name("confirmPassword")).sendKeys(Password);
	
 }
		
		
		driver.close();
		
}
}
