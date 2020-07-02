package DataDrivernTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestNG {
WebDriver driver;

@BeforeClass
public void LaunchBrowser() {
System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe")	;
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("http://newtours.demoaut.com/");
}

@Test(dataProvider="TestData")
public void getValue(String username, String password ) {
driver.findElement(By.name("userName")).sendKeys(username);
driver.findElement(By.name("password")).sendKeys(password);
driver.findElement(By.name("login")).click();

	
}

@DataProvider(name="TestData")
public void getData() throws IOException {
FileInputStream file =new FileInputStream("C:/Users/Priya/Desktop/ExcelSheets/datadrivernTest.xlsx");	
XSSFWorkbook workbook =new XSSFWorkbook(file);		
XSSFSheet sheet =workbook.getSheet("Sheet1");
int TotalRows =sheet.getLastRowNum();
int totalcell=sheet.getRow(0).getLastCellNum();

for(int i=0;i<TotalRows;i++) {
	XSSFRow row=sheet.getRow(i);
	 for(int j=0;j<totalcell;j++) {
		 String value= row.getCell(j).toString();
		 
		

		 
	 }
}
}
}
