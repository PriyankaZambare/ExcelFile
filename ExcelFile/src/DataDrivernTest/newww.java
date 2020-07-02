package DataDrivernTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class newww {
	public class Mavenproject {
		WebDriver driver;

		@BeforeMethod
			public void LaunchB() throws InterruptedException {
				System.setProperty("Webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
				driver= new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://demo.automationtesting.in/Register.html ");
				driver.navigate().refresh();
				Thread.sleep(3000);
		}
		@Test(dataProvider=" NameLast")
		public void LOgin(String username, String pass) {
			driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div[1]/input")).sendKeys(username);
			driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div[2]/input")).sendKeys(pass);
		}
		@DataProvider(name="NameLast")
		public Object[][]NAMES(){
			Object [][]data =new Object[2][2];
			data[0][0]= "RIANSHI";
			data[0][1]="PATIL";
			
			data[1][0]= "rianshi";
			data[1][1]="patil";
			return data;
		}
		}
}
