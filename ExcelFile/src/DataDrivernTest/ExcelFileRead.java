package DataDrivernTest;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class ExcelFileRead {
	
	WebDriver driver;
	
	@Test(dataProvider="Testdata")
	public void AdminLogin(String uname,String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe")	;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
	
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
String url= driver.getCurrentUrl();
	    Assert.assertEquals("http://newtours.demoaut.com/mercuryreservation.php", url);
	        }
	@AfterMethod
	    public void closebrowser() {
	    	driver.close();	}                
  @DataProvider(name="Testdata")
  public Object [][] readExcel() throws IOException {
  FileInputStream file =new FileInputStream("C:\\Users\\Priya\\Desktop\\ExcelSheets\\GCReddy InputFile.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);	          
		XSSFSheet sheet=workbook.getSheet("Sheet1");                //proving sheet name
		int rowcount = sheet.getLastRowNum();                   //return rows
		int colcount = sheet.getRow(0).getLastCellNum();     //return columns /cells
		 Object[][] data=new Object[rowcount][colcount];
				for(int i=0; i<rowcount;i++) { 
			XSSFRow currentrow = sheet.getRow(i);       //focused on current row
				   
		for(int j=0; j<colcount;j++) { 			   
		    String value = currentrow.getCell(j).toString(); //read the value from cell
		    System.out.print("   " +value); 
		    } 
		System.out.println();
}		
		 return data;		 	
}
      }

