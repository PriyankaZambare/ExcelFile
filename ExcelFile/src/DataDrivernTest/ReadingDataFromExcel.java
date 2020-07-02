package DataDrivernTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadingDataFromExcel {

public static void main(String[] args) throws IOException {
FileInputStream file =new FileInputStream("C:/Users/Priya/Desktop/inputE.xlsx");
XSSFWorkbook workbook = new XSSFWorkbook(file);	          
XSSFSheet sheet=workbook.getSheet("Sheet1");                //proving sheet name
int rowcount = sheet.getLastRowNum();                   //return rows
int colcount = sheet.getRow(0).getLastCellNum();     //return columns /cells
		
for(int i=0; i<rowcount;i++) { 
	XSSFRow currentrow = sheet.getRow(i);       //focused on current row
		   
for(int j=0; j<colcount;j++) { 			   
    String value = currentrow.getCell(j).toString(); //read the value from cell
    System.out.print("   " +value); } System.out.println();
    }
	System.out.println();	 	
}
}
