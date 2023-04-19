package Practice;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalucateIntersrestThroughWebDriver {

	public static void main(String[] args) throws Exception {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		
		FileInputStream file = new FileInputStream("C:\\Users\\HP\\OneDrive\\Documents\\SI.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Thread.sleep(2000);
		
		int rowcount = sheet.getLastRowNum();
		Thread.sleep(2000);
		for(int i=1;i<rowcount;i++)
		{
			XSSFRow row = sheet.getRow(i);
			Thread.sleep(2000);
			XSSFCell princeple = row.getCell(0);
			int princ = (int)princeple.getNumericCellValue();//type cating mean convert double into int value
			
			//int princ=(int)row.getCell(0).getNumericCellValue(); if type casting return in single line
			Thread.sleep(2000);
			XSSFCell roi=row.getCell(1);
			int rate = (int)roi.getNumericCellValue();
			
			Thread.sleep(2000);
			XSSFCell period = row.getCell(2);
			int time = (int)period.getNumericCellValue();
			
			Thread.sleep(2000);
			XSSFCell frequency = row.getCell(3);
			String frq = frequency.getStringCellValue();
			
			Thread.sleep(2000);
			XSSFCell maturity = row.getCell(4);
			int matur = (int)maturity.getNumericCellValue();
			
			Thread.sleep(2000);
			driver.findElement(By.id("principal")).sendKeys(String.valueOf(princ));
			driver.findElement(By.name("interest")).sendKeys(String.valueOf(rate));
			driver.findElement(By.name("tenure")).sendKeys(String.valueOf(time));
			
			Thread.sleep(2000);
			Select periodcombo = new Select(driver.findElement(By.name("tenurePeriod")));
			periodcombo.selectByVisibleText("year(s)");
			
			Thread.sleep(2000);
			Select frequen = new Select(driver.findElement(By.id("frequency")));
			frequen.selectByVisibleText("Simple Interest");
			Thread.sleep(2000);
			/*WebElement ddown = driver.findElement(By.id("frequency"));
			Select select = new Select(ddown);
			select.selectByValue("value=\"0\"");*/
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class=\"CTR PT15\"]/a")).submit();
			Thread.sleep(2000);
			String actualValue = driver.findElement(By.xpath("//span[@name=\"resp_matval\"]/strong")).getText();
			Thread.sleep(2000);
			if(Double.parseDouble(actualValue)==matur)
			{
				System.out.println("Test is passed");
			}
			else
			{
				System.out.println("Test is failed");
			}
			
			driver.findElement(By.xpath("//div[@class=\"CTR PT15\"]/a[2]/img")).submit();
			Thread.sleep(2000);
		}
		
		driver.close();
		driver.quit();
		
		/*import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practi {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdiver.chrome.driver", "A:\\Selenium\\JarFile\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		driver.findElement(By.name("principal")).sendKeys("20000");
		Thread.sleep(2000);
		driver.findElement(By.id("interest")).sendKeys("10");
		Thread.sleep(2000);
		driver.findElement(By.name("tenure")).sendKeys("2");
		
		WebElement ddow = driver.findElement(By.name("tenurePeriod"));
		Select select = new Select(ddow);
		select.selectByValue("1");
		
		WebElement dow = driver.findElement(By.name("frequency"));
		Select selected = new Select(dow);
		selected.selectByVisibleText("Simple Interest");
		
		driver.findElement(By.xpath("//a[@onclick=\"return getfdMatVal(this);\"]/img")).submit();

	}

}
*/
	}
}
