package DataDrivernTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MoneyControl {

public static void main(String[] args) throws IOException {

System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html?classic=true");

FileInputStream file =new FileInputStream("C:\\Users\\Priya\\Desktop\\ExcelSheets\\MonetControl.xlsx");  //create file object for reading the file

XSSFWorkbook workbook =new XSSFWorkbook(file);   //create workbook object

XSSFSheet sheet=workbook.getSheet("Sheet1");

int totalrow =sheet.getLastRowNum();

for(int i=1;i<totalrow;i++) {
	XSSFRow row= sheet.getRow(i);
	row.getCell(i).setCellType(CellType.NUMERIC);
	XSSFCell principal=row.getCell(0);
	int prin= (int)principal.getNumericCellValue();
	
	XSSFCell rateOfIntrest=row.getCell(1);
	int rate=(int)rateOfIntrest.getNumericCellValue();
	
    XSSFCell prd=row.getCell(2);
    int per=(int)prd.getNumericCellValue();
    
    XSSFCell Frequency=row.getCell(3);
    int fq= (int)Frequency.getNumericCellValue();      //Cannot get a NUMERIC value from a STRING cell
    
    XSSFCell MaturityValue=row.getCell(4); 
    int aMV= (int)MaturityValue.getNumericCellValue();
    
    
    driver.findElement(By.id("principal")).sendKeys(String.valueOf(prin));
    driver.findElement(By.id("interest")).sendKeys(String.valueOf(rate));
    driver.findElement(By.id("tenure")).sendKeys(String.valueOf(per));
    
    
    Select periodCom = new Select(driver.findElement(By.id("tenurePeriod")));
    periodCom.selectByVisibleText("year(s)");

    Select frequency =new Select(driver.findElement(By.id("frequency")));
    frequency.selectByVisibleText("Simple Interest");
    
    String eMV=driver.findElement(By.xpath("//*[@id='response_div']/div/div[2]")).getText();
    
    if(Double.parseDouble(eMV)==aMV) {
    	System.out.println("Test is Pass");
    }
    
    else {
    	System.out.println("Test is Fail");
    }
    
    driver.findElement(By.xpath("//*[@id=\'fdMatVal\']/div[2]/a[1]/img")).click();
    driver.findElement(By.xpath("//*[@id=\'fdMatVal\']/div[2]/a[2]/img")).click();
    driver.close();
}


driver.quit();
	
	
	
	
	
	
	
}
}
